package com.arstagaev.solarpanelx.navigation.screens.anothertest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arstagaev.solarpanelx.navigation.screens.anothertest.IAnotherTestComponent

@Composable
fun AnotherTestScreen(component: IAnotherTestComponent) {
    Box(Modifier.fillMaxSize().background(Color.Blue))
}