package com.mimotts.android.di

import com.mimotts.android.data.api.MiMoApiService
import com.mimotts.android.data.datastore.SettingsDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { SettingsDataStore(androidContext()) }
    single { MiMoApiService() }
}
