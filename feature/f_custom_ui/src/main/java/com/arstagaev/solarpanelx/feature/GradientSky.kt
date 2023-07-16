package com.arstagaev.solarpanelx.feature

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.arstagaev.solarpanelx.colorClearSky1
import com.arstagaev.solarpanelx.colorElegantGray
import com.arstagaev.solarpanelx.colorOrange1
import com.arstagaev.solarpanelx.colorOrange2
import com.arstagaev.solarpanelx.colorOrange3
import com.arstagaev.solarpanelx.colorParmesan


@Composable
fun GradientSky() {
    var path = remember {
        mutableStateOf(0.0f)
    }
    LaunchedEffect(key1 = true) {
        var timer =  object :  CountDownTimer(10000,100){
            override fun onTick(millisUntilFinished: Long) {
                path.value = path.value+10f
            }

            override fun onFinish() {}
        }.start()
    }
    var size by remember { mutableStateOf(IntSize(0,0)) }
    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            //.height((size.height*0.5f).dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Red,
                        colorClearSky1,
                        colorClearSky1,
                        colorElegantGray,
                    )
                ),
                alpha = 1.0f
            )
        )
        Box(modifier = Modifier
            .fillMaxSize()
            //.fillMaxWidth()
//            .fillMaxHeight()
//            .height((size.height*0.5f).dp)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        colorOrange1,
                        colorOrange2,
                        colorParmesan,
                        colorParmesan,
                        colorParmesan,
                    ),
                    center = Offset(path.value, 0.0f)
                ),
                alpha = 0.7f
            )
        )
//        Box(modifier = Modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.linearGradient(
//                    colors = listOf(
//                        Color.Yellow,
//                        Color.Red,
//                        Color.Yellow,
//                    )
//                ),
//                alpha = 0.5f
//            )
//        )
//        Box(modifier = Modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.radialGradient(
//                    colors = listOf(
//                        Color.LightGray,
//                        Color.Gray,
//                        Color.DarkGray,
//                    )
//                ),
//                alpha = 0.5f
//            )
//        )
    }

}