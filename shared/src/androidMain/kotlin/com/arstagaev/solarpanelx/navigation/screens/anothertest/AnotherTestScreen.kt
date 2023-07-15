package com.arstagaev.solarpanelx.navigation.screens.anothertest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arstagaev.solarpanelx.navigation.screens.anothertest.IAnotherTestComponent
import com.arstagaev.solarpanelx.utils.Loading

@Composable
fun AnotherTestScreen(component: IAnotherTestComponent) {
    val state by component.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        component.getAllCharacters("Sochi")
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)) {
        if (state?.isLoading == true) {
            Loading()
        }else {
            Column() {
                Text("${state?.success?.name}  ${state?.success?.feelslike_c}")
                Text("${state?.error}")
            }

        }

    }
}