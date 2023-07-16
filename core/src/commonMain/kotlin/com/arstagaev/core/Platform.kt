package com.arstagaev.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform