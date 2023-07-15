package com.arstagaev.solarpanelx.navigation.screens.anothertest

import com.arkivanov.decompose.ComponentContext

interface IAnotherTestComponent {

    // Omitted code

    fun onCloseClicked()
}

class AnotherTestComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit
) : IAnotherTestComponent, ComponentContext by componentContext {

    // Omitted code

    override fun onCloseClicked() {
        onBack
    }
}