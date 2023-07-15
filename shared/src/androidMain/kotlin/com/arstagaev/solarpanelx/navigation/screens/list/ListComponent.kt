package com.arstagaev.solarpanelx.navigation.screens.list

import com.arkivanov.decompose.ComponentContext

interface IListComponent {

    // Omitted code

    fun onItemClicked(id: Long)
}

class ListComponent(
    componentContext: ComponentContext,
    private val onItemSelected: (id: Long) -> Unit
) : IListComponent, ComponentContext by componentContext {

    // Omitted code

    override fun onItemClicked(id: Long) {
        onItemSelected(id)
    }
}