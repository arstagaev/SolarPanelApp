package com.arstagaev.core.ui.navigation.screens.main_dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arstagaev.solarpanelx.colorDashboardDown
import com.arstagaev.solarpanelx.colorDashboardMid
import com.arstagaev.solarpanelx.colorDashboardUpper
import com.arstagaev.solarpanelx.feature.GradientSky
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.patrykandpatrick.vico.views.chart.line.lineChart

@Composable
fun MainDashboardScreen(component: MainDashboardComponent) {
    val chartEntryModel = entryModelOf(1 to 4f, 2 to 12f,3 to 8f,4 to  16f)
    Box(modifier = Modifier.fillMaxSize()) {
        GradientSky()
        Column(
            Modifier
                .fillMaxSize()
                //.background(Color.Green)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.fillMaxWidth().height(40.dp))
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(top = 10.dp, bottom = 2.dp, start = 5.dp, end = 5.dp),
                elevation = 20.dp,
                shape = RoundedCornerShape(
                    topStart = 90.dp,
                    topEnd = 90.dp,
                    bottomStart = 30.dp,
                    bottomEnd = 30.dp
                )
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorDashboardUpper,
                                colorDashboardMid,
                                colorDashboardDown
                            )
                        )
                    )){
                    Row(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(bottom = 15.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            modifier = Modifier.height(IntrinsicSize.Min),
                            text = "64",
                            color = Color.White,
                            fontFamily = FontFamily.Default, fontSize = 60.sp, fontWeight = FontWeight.Bold,textAlign = TextAlign.Center,
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 9.dp),
                            text = "%",
                            color = Color.White,
                            fontFamily = FontFamily.Default,
                            fontStyle = FontStyle.Normal,
                            fontSize = 20.sp
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .align(Alignment.BottomEnd),
                    ) {
                        LinearProgressIndicator(
                            modifier = Modifier.fillMaxSize(),
                            progress = 0.7f,
                            color = Color.Yellow,
                            backgroundColor = Color.Transparent
                        )
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(
                                modifier = Modifier,
                                text = "7:00",
                                color = Color.DarkGray,
                                fontFamily = FontFamily.Default,
                                fontStyle = FontStyle.Normal,
                                fontSize = 6.sp
                            )
                            Text(
                                modifier = Modifier,
                                text = "7:00",
                                color = Color.DarkGray,
                                fontFamily = FontFamily.Default,
                                fontStyle = FontStyle.Normal,
                                fontSize = 6.sp
                            )
                            Text(
                                modifier = Modifier,
                                text = "7:00",
                                color = Color.DarkGray,
                                fontFamily = FontFamily.Default,
                                fontStyle = FontStyle.Normal,
                                fontSize = 6.sp
                            )
                        }
                    }

                }
            }
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 20.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                Chart(
                    modifier = Modifier.fillMaxWidth(),
                    chart = lineChart(LocalContext.current),
                    model = chartEntryModel,
                    startAxis = startAxis(),
                    bottomAxis = bottomAxis(),
                    isZoomEnabled = true
                )
            }
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 20.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                Chart(
                    modifier = Modifier.fillMaxWidth(),
                    chart = lineChart(LocalContext.current),
                    model = chartEntryModel,
                    startAxis = startAxis(),
                    bottomAxis = bottomAxis(),
                    isZoomEnabled = true
                )
            }
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 20.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                Chart(
                    modifier = Modifier.fillMaxWidth(),
                    chart = lineChart(LocalContext.current),
                    model = chartEntryModel,
                    startAxis = startAxis(),
                    bottomAxis = bottomAxis(),
                    isZoomEnabled = true
                )
            }

        }
    }

}