package com.arstagaev.core.ui.navigation.screens.main_dashboard

import com.arkivanov.decompose.ComponentContext

interface IMainDashboardComponent {

    // Omitted code

    fun onItemClicked(id: Long)
}

class MainDashboardComponent(
    componentContext: ComponentContext,
    private val onItemSelected: (id: Long) -> Unit
) : IMainDashboardComponent, ComponentContext by componentContext {

    // Omitted code

    override fun onItemClicked(id: Long) {
        onItemSelected(id)
    }
}