package com.mimotts.android

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mimotts.android.ui.pages.history.HistoryPage
import com.mimotts.android.ui.pages.settings.SettingsPage
import com.mimotts.android.ui.pages.tts.TTSPage
import com.mimotts.android.ui.pages.tts.TTSViewModel
import com.mimotts.android.ui.theme.MiMoTTSTheme
import org.koin.compose.viewmodel.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        
        // 适配高刷屏幕 - 设置为系统支持的最高刷新率
        window.attributes = window.attributes.apply {
            preferredRefreshRate = 120f
        }
        
        // 允许屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContent {
            MiMoTTSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "tts"
                    ) {
                        composable("tts") {
                            TTSPage(
                                onNavigateToHistory = { navController.navigate("history") },
                                onNavigateToSettings = { navController.navigate("settings") }
                            )
                        }
                        composable("history") {
                            val ttsViewModel: TTSViewModel = koinViewModel()
                            HistoryPage(
                                onNavigateBack = { navController.popBackStack() },
                                viewModel = ttsViewModel
                            )
                        }
                        composable("settings") {
                            val ttsViewModel: TTSViewModel = koinViewModel()
                            SettingsPage(
                                onNavigateBack = { navController.popBackStack() },
                                viewModel = ttsViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}
