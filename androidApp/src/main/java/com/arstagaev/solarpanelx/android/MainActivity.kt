package com.arstagaev.solarpanelx.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.arstagaev.solarpanelx.navigation.root.RootComponent
import com.arstagaev.solarpanelx.navigation.root.RootContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Always create the root component outside Compose on the main thread
        val root = RootComponent(componentContext = defaultComponentContext())

        setContent {
            MaterialTheme {
                Surface {
                    RootContent(component = root, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
