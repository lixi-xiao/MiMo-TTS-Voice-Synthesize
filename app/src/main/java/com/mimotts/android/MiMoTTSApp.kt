package com.mimotts.android

import android.app.Application
import com.mimotts.android.di.appModule
import com.mimotts.android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MiMoTTSApp : Application() {
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger()
            androidContext(this@MiMoTTSApp)
            modules(appModule, viewModelModule)
        }
    }
}
