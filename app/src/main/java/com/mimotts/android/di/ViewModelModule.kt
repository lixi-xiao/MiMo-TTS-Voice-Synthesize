package com.mimotts.android.di

import com.mimotts.android.ui.pages.tts.TTSViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TTSViewModel(get(), get()) }
}
