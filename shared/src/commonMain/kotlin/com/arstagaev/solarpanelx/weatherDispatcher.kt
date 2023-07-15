package com.arstagaev.solarpanelx

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val provideDispatcher: Dispatcher