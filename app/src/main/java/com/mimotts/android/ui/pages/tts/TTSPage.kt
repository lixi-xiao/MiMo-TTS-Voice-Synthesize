package com.mimotts.android.ui.pages.tts

import android.media.MediaPlayer
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import com.mimotts.android.data.model.AudioFormat
import com.mimotts.android.data.model.PRESET_VOICES
import com.mimotts.android.data.model.TAG_GROUPS
import com.mimotts.android.data.model.TTSModel
import com.mimotts.android.ui.theme.MiMoOrange
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun TTSPage(
    onNavigateToHistory: () -> Unit,
    onNavigateToSettings: () -> Unit,
    viewModel: TTSViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    var showDownloadDialog by remember { mutableStateOf(false) }
    var customFilename by remember { mutableStateOf("") }

    val settings by viewModel.settings.collectAsStateWithLifecycle()
    val isGenerating by viewModel.isGenerating.collectAsStateWithLifecycle()
    val audioUriState by viewModel.audioUri.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    val voiceCloneUri by viewModel.voiceCloneUri.collectAsStateWithLifecycle()

    // 当前激活的标签从 settings.styleTags 获取
    val activeTagsSet = remember(settings.styleTags) { settings.styleTags.toSet() }

    // 当前激活的 API 配置
    val activeApiConfig = settings.apiConfigs.find { it.id == settings.activeApiId }

    // 独立维护文本状态，避免每次 recompose 都触发 viewModel.textState.edit
    var text by remember { mutableStateOf("") }

    val bringIntoViewRequester = remember { BringIntoViewRequester() }

    // 音色描述本地状态，避免每次输入都触发 DataStore 更新导致焦点丢失
    var voiceDescription by remember { mutableStateOf(settings.voiceDescription) }

    // 双向同步：viewModel.textState 变化时同步到本地 text
    LaunchedEffect(viewModel.textState.text.toString()) {
        val viewModelText = viewModel.textState.text.toString()
        if (viewModelText != text) {
            text = viewModelText
        }
    }

    // 本地 text 变化时同步到 viewModel.textState
    LaunchedEffect(text) {
        val viewModelText = viewModel.textState.text.toString()
        if (viewModelText != text) {
            viewModel.textState.edit { replace(0, length, text) }
        }
    }

    // 双向同步：DataStore 中的 voiceDescription 变化时同步到本地状态
    LaunchedEffect(settings.voiceDescription) {
        if (settings.voiceDescription != voiceDescription) {
            voiceDescription = settings.voiceDescription
        }
    }

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
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // API 状态提示条
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onNavigateToSettings),
                shape = MaterialTheme.shapes.small,
                color = MaterialTheme.colorScheme.surfaceVariant,
                tonalElevation = 1.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "当前 API: ${activeApiConfig?.name ?: "未配置"}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "前往设置",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

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
                    description = voiceDescription,
                    onDescriptionChange = {
                        voiceDescription = it
                        viewModel.updateVoiceDescription(it)
                    }
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
                text = text,
                onTextChange = { text = it },
                activeTags = activeTagsSet,
                onToggleTag = { tag -> viewModel.toggleTag(tag) },
                onClear = { viewModel.clearAll(); text = "" },
                bringIntoViewRequester = bringIntoViewRequester
            )

            GenerateButton(
                isGenerating = isGenerating,
                onGenerate = { viewModel.generateSpeech(context) }
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
                    },
                    onDownload = {
                        showDownloadDialog = true
                    }
                )
            }
        }

        // 下载对话框
        if (showDownloadDialog) {
            val currentSettings = settings
            val defaultName = remember {
                val timestamp = java.text.SimpleDateFormat("yyyy-M-d HH:mm", java.util.Locale.getDefault()).format(java.util.Date())
                val modeName = when (currentSettings.selectedModel) {
                    TTSModel.VOICE_DESIGN -> "音频设计"
                    TTSModel.VOICE_CLONE -> "音频克隆"
                    else -> "预置音色"
                }
                "$timestamp $modeName"
            }

            AlertDialog(
                onDismissRequest = { showDownloadDialog = false },
                title = { Text("保存音频") },
                text = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("文件名（不含扩展名）：")
                        OutlinedTextField(
                            value = customFilename,
                            onValueChange = { customFilename = it },
                            placeholder = { Text(defaultName) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            "留空将使用默认文件名",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val finalName = customFilename.takeIf { it.isNotBlank() } ?: defaultName
                            viewModel.downloadAudio(context, finalName)
                            showDownloadDialog = false
                            customFilename = ""
                        }
                    ) {
                        Text("保存")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDownloadDialog = false }) {
                        Text("取消")
                    }
                }
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
        placeholder = {
            Text(
                "描述你想要的音色特征...\n" +
                "例如：温柔的女声，像电台主持人一样\n" +
                "建议包含：性别、年龄、音色质感、情绪语气\n" +
                "支持中英文描述"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        maxLines = 10,
        singleLine = false,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.None)
    )
    Text(
        "描述越具体，生成的音色越贴近预期（1-4句即可）",
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

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
private fun TextInputSection(
    text: String,
    onTextChange: (String) -> Unit,
    activeTags: Set<String>,
    onToggleTag: (String) -> Unit,
    onClear: () -> Unit,
    bringIntoViewRequester: BringIntoViewRequester
) {
    val coroutineScope = rememberCoroutineScope()
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
                    group.tags.forEach { tag ->
                        val isActive = activeTags.contains(tag)
                        FilterChip(
                            selected = isActive,
                            onClick = { onToggleTag(tag) },
                            label = { Text(tag) },
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
            value = text,
            onValueChange = {
                onTextChange(it)
                coroutineScope.launch {
                    bringIntoViewRequester.bringIntoView()
                }
            },
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
                .height(200.dp)
                .bringIntoViewRequester(bringIntoViewRequester),
            maxLines = 10,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Default)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "${text.length} 字",
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
            Text("开始合成")
        }
    }
}

@Composable
private fun AudioPlayerCard(
    audioUri: Uri?,
    isPlaying: Boolean,
    onPlayPause: () -> Unit,
    onDownload: () -> Unit = {}
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

            // 下载按钮 - 使用 Settings 图标作为临时替代，添加文字标签
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = onDownload,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "保存音频",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    "保存",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
