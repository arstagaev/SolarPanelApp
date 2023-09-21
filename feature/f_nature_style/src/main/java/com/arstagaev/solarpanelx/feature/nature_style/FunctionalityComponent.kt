package com.arstagaev.solarpanelx.feature.nature_style

import com.arkivanov.decompose.ComponentContext

interface IFunctionalityComponent {

    // Omitted code

    fun onCloseClicked()
}

class FunctionalityComponent(
    componentContext: ComponentContext,
    itemId: Long,
    private val onFinished: () -> Unit
) : IFunctionalityComponent, ComponentContext by componentContext {

    // Omitted code

    override fun onCloseClicked() {
        onFinished()
    }
}
