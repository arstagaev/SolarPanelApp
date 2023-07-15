package com.arstagaev.solarpanelx.util

import com.arstagaev.solarpanelx.di.sharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(sharedModules)
    }
}