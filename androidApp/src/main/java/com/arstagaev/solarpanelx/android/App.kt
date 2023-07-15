package com.arstagaev.solarpanelx.android

import android.app.Application
import com.arstagaev.solarpanelx.di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(applicationContext)
            modules(sharedModules)
        }
    }
}