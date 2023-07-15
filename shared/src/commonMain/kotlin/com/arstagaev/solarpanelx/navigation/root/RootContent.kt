package com.arstagaev.solarpanelx.navigation.root

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arstagaev.solarpanelx.navigation.root.IRootComponent
import nav.screen.anothertest.AnotherTestScreen
import nav.screen.details.DetailsScreen
import nav.screen.list.ListScreen

@Composable
fun RootContent(
    component: IRootComponent,
    modifier: Modifier = Modifier
) {
    val childStack by component.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance

    Column(Modifier.fillMaxWidth()) {
        Children(
            stack = component.childStack,
            animation = stackAnimation(fade()),
            modifier = Modifier.weight(weight = 1F)
        ) {
            when (val child = it.instance) {
                is IRootComponent.Child.ListChild -> ListScreen(child.component)
                is IRootComponent.Child.DetailsChild -> DetailsScreen(child.component)
                is IRootComponent.Child.AnotherTest -> AnotherTestScreen(child.component)
            }
        }
        BottomNavigation(modifier = Modifier.fillMaxWidth()) {
            BottomNavigationItem(
                selected = activeComponent is IRootComponent.Child.ListChild,
                onClick = component::onCountersTabClicked,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Counters",
                    )
                },
                label = { Text(text = "Counters", softWrap = false) },
            )
            BottomNavigationItem(
                selected = activeComponent is IRootComponent.Child.AnotherTest,
                onClick = component::onAnotherTestTabClicked,
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "AccountBox",
                    )
                },
                label = { Text(text = "AccountBox", softWrap = false) },
            )
        }
    }
}
