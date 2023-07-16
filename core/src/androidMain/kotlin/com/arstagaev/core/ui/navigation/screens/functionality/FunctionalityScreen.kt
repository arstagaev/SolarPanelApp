package com.arstagaev.core.ui.navigation.screens.functionality

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arstagaev.core.ui.navigation.screens.functionality.IFunctionalityComponent

@Composable
fun FunctionalityScreen(component: IFunctionalityComponent) {
    Box(Modifier.fillMaxSize().background(Color.Red))
}