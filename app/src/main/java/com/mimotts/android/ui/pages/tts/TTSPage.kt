package com.mimotts.android.ui.pages.tts

import android.media.MediaPlayer
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mimotts.android.data.model.ApiMode
import com.mimotts.android.data.model.AudioFormat
import com.mimotts.android.data.model.PRESET_VOICES
import com.mimotts.android.data.model.TAG_GROUPS
import com.mimotts.android.data.model.TTSModel
import com.mimotts.android.ui.theme.MiMoOrange
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TTSPage(
    onNavigateToHistory: () -> Unit,
    onNavigateToSettings: () -> Unit,
    viewModel: TTSViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    
    val settings by viewModel.settings.collectAsStateWithLifecycle()
    val isGenerating by viewModel.isGenerating.collectAsStateWithLifecycle()
    val audioUriState by viewModel.audioUri.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    val activeTags by viewModel.activeTags.collectAsStateWithLifecycle()
    val voiceCloneUri by viewModel.voiceCloneUri.collectAsStateWithLifecycle()
    
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var isPlaying by remember { mutableStateOf(false) }
    
    val audioPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.setVoiceCloneUri(it) }
    }
    
    LaunchedEffect(error) {
        error?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.dismissError()
        }
    }
    
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "MiMo TTS",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                actions = {
                    IconButton(onClick = onNavigateToHistory) {
                        Icon(Icons.Default.List, contentDescription = "历史")
                    }
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(Icons.Default.Settings, contentDescription = "设置")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ApiModeSection(
                apiMode = settings.apiMode,
                onModeChange = { viewModel.updateApiMode(it) }
            )
            
            ApiKeySection(
                apiMode = settings.apiMode,
                planToken = settings.planToken,
                apiKey = settings.apiKey,
                onPlanTokenChange = { viewModel.updatePlanToken(it) },
                onApiKeyChange = { viewModel.updateApiKey(it) }
            )
            
            HorizontalDivider()
            
            ModelSelectionSection(
                selectedModel = settings.selectedModel,
                onModelChange = { viewModel.updateSelectedModel(it) }
            )
            
            when (settings.selectedModel) {
                TTSModel.PRESET -> VoiceSelectionSection(
                    selectedVoice = settings.selectedVoice,
                    onVoiceChange = { viewModel.updateSelectedVoice(it) }
                )
                TTSModel.VOICE_DESIGN -> VoiceDesignSection(
                    description = settings.voiceDescription,
                    onDescriptionChange = { viewModel.updateVoiceDescription(it) }
                )
                TTSModel.VOICE_CLONE -> VoiceCloneSection(
                    cloneUri = voiceCloneUri,
                    onPickAudio = { audioPicker.launch("audio/*") }
                )
            }
            
            AudioFormatSection(
                format = settings.audioFormat,
                onFormatChange = { viewModel.updateAudioFormat(it) }
            )
            
            HorizontalDivider()
            
            TextInputSection(
                textState = viewModel.textState,
                activeTags = activeTags,
                onToggleTag = { name, text -> viewModel.toggleTag(name, text) },
                onClear = { viewModel.clearAll() }
            )
            
            GenerateButton(
                isGenerating = isGenerating,
                onGenerate = { viewModel.generateSpeech(context.cacheDir) }
            )
            
            AnimatedVisibility(
                visible = audioUriState != null,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                AudioPlayerCard(
                    audioUri = audioUriState,
                    isPlaying = isPlaying,
                    onPlayPause = {
                        if (isPlaying) {
                            mediaPlayer?.pause()
                            isPlaying = false
                        } else {
                            audioUriState?.let { uri ->
                                mediaPlayer?.release()
                                mediaPlayer = MediaPlayer.create(context, uri).apply {
                                    setOnCompletionListener { isPlaying = false }
                                    start()
                                }
                                isPlaying = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ApiModeSection(
    apiMode: ApiMode,
    onModeChange: (ApiMode) -> Unit
) {
    Column {
        Text(
            "API 接入方式",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
            SegmentedButton(
                selected = apiMode == ApiMode.PLAN,
                onClick = { onModeChange(ApiMode.PLAN) },
                shape = SegmentedButtonDefaults.itemShape(index = 0, count = 2)
            ) {
                Text("MiMo Plan")
            }
            SegmentedButton(
                selected = apiMode == ApiMode.API_KEY,
                onClick = { onModeChange(ApiMode.API_KEY) },
                shape = SegmentedButtonDefaults.itemShape(index = 1, count = 2)
            ) {
                Text("API Key")
            }
        }
    }
}

@Composable
private fun ApiKeySection(
    apiMode: ApiMode,
    planToken: String,
    apiKey: String,
    onPlanTokenChange: (String) -> Unit,
    onApiKeyChange: (String) -> Unit
) {
    when (apiMode) {
        ApiMode.PLAN -> {
            OutlinedTextField(
                value = planToken,
                onValueChange = onPlanTokenChange,
                label = { Text("Plan Token") },
                placeholder = { Text("mimo-plan-...") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Text(
                "在 MiMo Plan 控制台获取 Token",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        ApiMode.API_KEY -> {
            OutlinedTextField(
                value = apiKey,
                onValueChange = onApiKeyChange,
                label = { Text("API Key") },
                placeholder = { Text("sk-...") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Text(
                "从 platform.xiaomimimo.com 获取",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun ModelSelectionSection(
    selectedModel: TTSModel,
    onModelChange: (TTSModel) -> Unit
) {
    Column {
        Text(
            "模型选择",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
            SegmentedButton(
                selected = selectedModel == TTSModel.PRESET,
                onClick = { onModelChange(TTSModel.PRESET) },
                shape = SegmentedButtonDefaults.itemShape(index = 0, count = 3)
            ) {
                Text("预置音色")
            }
            SegmentedButton(
                selected = selectedModel == TTSModel.VOICE_DESIGN,
                onClick = { onModelChange(TTSModel.VOICE_DESIGN) },
                shape = SegmentedButtonDefaults.itemShape(index = 1, count = 3)
            ) {
                Text("音色设计")
            }
            SegmentedButton(
                selected = selectedModel == TTSModel.VOICE_CLONE,
                onClick = { onModelChange(TTSModel.VOICE_CLONE) },
                shape = SegmentedButtonDefaults.itemShape(index = 2, count = 3)
            ) {
                Text("音色克隆")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun VoiceSelectionSection(
    selectedVoice: String,
    onVoiceChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        OutlinedTextField(
            value = selectedVoice,
            onValueChange = {},
            readOnly = true,
            label = { Text("选择音色") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )
        
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            PRESET_VOICES.forEach { voice ->
                DropdownMenuItem(
                    text = { Text(voice) },
                    onClick = {
                        onVoiceChange(voice)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun VoiceDesignSection(
    description: String,
    onDescriptionChange: (String) -> Unit
) {
    OutlinedTextField(
        value = description,
        onValueChange = onDescriptionChange,
        label = { Text("音色描述") },
        placeholder = { Text("例如：温柔的女声，像电台主持人一样") },
        modifier = Modifier.fillMaxWidth(),
        minLines = 2,
        maxLines = 4
    )
    Text(
        "描述越具体，生成的音色越贴近预期",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Composable
private fun VoiceCloneSection(
    cloneUri: Uri?,
    onPickAudio: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "上传音频样本",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                "支持 wav 和 mp3 格式，文件大小不超过 10MB",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            if (cloneUri != null) {
                Text(
                    "已选择: ${cloneUri.lastPathSegment}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            
            Button(
                onClick = onPickAudio,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (cloneUri == null) "选择音频文件" else "更换音频文件")
            }
        }
    }
}

@Composable
private fun AudioFormatSection(
    format: AudioFormat,
    onFormatChange: (AudioFormat) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "音频格式:",
            style = MaterialTheme.typography.bodyMedium
        )
        
        FilterChip(
            selected = format == AudioFormat.WAV,
            onClick = { onFormatChange(AudioFormat.WAV) },
            label = { Text("WAV") }
        )
        
        FilterChip(
            selected = format == AudioFormat.MP3,
            onClick = { onFormatChange(AudioFormat.MP3) },
            label = { Text("MP3") }
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TextInputSection(
    textState: androidx.compose.foundation.text.input.TextFieldState,
    activeTags: Set<String>,
    onToggleTag: (String, String) -> Unit,
    onClear: () -> Unit
) {
    Column {
        TAG_GROUPS.forEach { group ->
            Column(modifier = Modifier.padding(bottom = 8.dp)) {
                Text(
                    group.name,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    group.tags.forEach { (name, tagText) ->
                        val isActive = activeTags.contains(name)
                        FilterChip(
                            selected = isActive,
                            onClick = { onToggleTag(name, tagText) },
                            label = { Text(name) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MiMoOrange.copy(alpha = 0.2f),
                                selectedLabelColor = MiMoOrange
                            )
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            state = textState,
            label = { Text("合成文本") },
            placeholder = { 
                Text(
                    "在这里输入要合成的文本...\n" +
                    "示例：\n" +
                    "  (开心)你好呀，今天天气真好！\n" +
                    "  (东北话)哥们儿，整点啥？\n" +
                    "  [笑]哈哈哈，太好笑了！"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 5, maxHeightInLines = 10)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "${textState.text.length} 字",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            TextButton(onClick = onClear) {
                Text("清空全部")
            }
        }
    }
}

@Composable
private fun GenerateButton(
    isGenerating: Boolean,
    onGenerate: () -> Unit
) {
    Button(
        onClick = onGenerate,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = !isGenerating,
        colors = ButtonDefaults.buttonColors(
            containerColor = MiMoOrange
        )
    ) {
        if (isGenerating) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("正在合成...")
        } else {
            Text("🎵 开始合成")
        }
    }
}

@Composable
private fun AudioPlayerCard(
    audioUri: Uri?,
    isPlaying: Boolean,
    onPlayPause: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FilledIconButton(
                    onClick = onPlayPause,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        if (isPlaying)
                            Icons.Default.Clear
                        else
                            Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "暂停" else "播放"
                    )
                }
                
                Column {
                    Text(
                        "合成完成",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        audioUri?.lastPathSegment ?: "",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
