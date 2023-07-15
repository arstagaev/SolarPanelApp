package nav.screen.anothertest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AnotherTestScreen(component: IAnotherTestComponent) {
    Box(Modifier.fillMaxSize().background(Color.Blue))
}