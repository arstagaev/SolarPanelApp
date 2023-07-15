package com.arstagaev.solarpanelx.navigation.screens.details

import com.arkivanov.decompose.ComponentContext

interface IDetailsComponent {

    // Omitted code

    fun onCloseClicked()
}

class DetailsComponent(
    componentContext: ComponentContext,
    itemId: Long,
    private val onFinished: () -> Unit
) : IDetailsComponent, ComponentContext by componentContext {

    // Omitted code

    override fun onCloseClicked() {
        onFinished()
    }
}
