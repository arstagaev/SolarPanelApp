package com.arstagaev.solarpanelx.navigation.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arstagaev.solarpanelx.navigation.screens.list.ListComponent

@Composable
fun ListScreen(component: ListComponent) {
    Box(Modifier.fillMaxSize().background(Color.Green).clickable {
        component.onItemClicked(1)
    })
}