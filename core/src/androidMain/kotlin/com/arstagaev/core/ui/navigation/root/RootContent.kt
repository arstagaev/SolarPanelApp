package com.arstagaev.core.ui.navigation.root

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.twotone.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arstagaev.core.ui.navigation.screens.premium_adv.PremiumAdvScreen
import com.arstagaev.core.ui.navigation.screens.functionality.FunctionalityScreen
import com.arstagaev.core.ui.navigation.screens.main_dashboard.MainDashboardScreen

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
                is IRootComponent.Child.MainDashboardChild -> MainDashboardScreen(child.component)
                is IRootComponent.Child.FunctionalityChild -> FunctionalityScreen(child.component)
                is IRootComponent.Child.PremiumAdvChild -> PremiumAdvScreen(child.component)
            }
        }
        BottomNavigation(modifier = Modifier.fillMaxWidth()) {
            BottomNavigationItem(
                selected = activeComponent is IRootComponent.Child.MainDashboardChild,
                onClick = component::onCountersTabClicked,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                    )
                },
                label = { Text(text = "spx", softWrap = false) },
            )
            BottomNavigationItem(
                selected = activeComponent is IRootComponent.Child.PremiumAdvChild,
                onClick = component::onAnotherTestTabClicked,
                icon = {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "Functional",
                    )
                },
                label = { Text(text = "Functional", softWrap = false) },
            )
            BottomNavigationItem(
                selected = activeComponent is IRootComponent.Child.PremiumAdvChild,
                onClick = component::onAnotherTestTabClicked,
                icon = {
                    Icon(
                        imageVector = Icons.TwoTone.Star,
                        contentDescription = "Pro",
                    )
                },
                label = { Text(text = "Pro", softWrap = false) },
            )
        }
    }
}
