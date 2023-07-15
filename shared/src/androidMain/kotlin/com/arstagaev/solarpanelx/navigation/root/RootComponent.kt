package com.arstagaev.solarpanelx.navigation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arstagaev.solarpanelx.navigation.screens.anothertest.AnotherTestComponent
import com.arstagaev.solarpanelx.navigation.screens.anothertest.IAnotherTestComponent
import com.arstagaev.solarpanelx.navigation.screens.details.DetailsComponent
import com.arstagaev.solarpanelx.navigation.screens.details.IDetailsComponent
import com.arstagaev.solarpanelx.navigation.screens.list.ListComponent

interface IRootComponent {

    val childStack: Value<ChildStack<*, Child>>

    fun onCountersTabClicked()
    fun onAnotherTestTabClicked()
    // methods will can add

    sealed class Child {
        class ListChild(val component: ListComponent) : Child()
        class DetailsChild(val component: IDetailsComponent) : Child()
        class AnotherTest(val component: IAnotherTestComponent) : Child()
    }
}

class RootComponent(
    componentContext: ComponentContext
) : IRootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val _childStack =
        childStack(
            source = navigation,
            initialConfiguration = Config.List,
            handleBackButton = true, // Pop the back stack on back button press
            childFactory = ::createChild,
        )

    override val childStack: Value<ChildStack<*, IRootComponent.Child>> = _childStack

    override fun onCountersTabClicked() {
        //navigation.push(Config.List)
        navigation.bringToFront(Config.List)
    }

    override fun onAnotherTestTabClicked() {
        //navigation.push(Config.AnotherTest)
        navigation.bringToFront(Config.AnotherTest)
    }

    private fun createChild(config: Config, componentContext: ComponentContext): IRootComponent.Child =
        when (config) {
            is Config.List -> IRootComponent.Child.ListChild(createItemList(componentContext))
            is Config.Details -> IRootComponent.Child.DetailsChild(
                createItemDetails(
                    componentContext,
                    config
                )
            )
            is Config.AnotherTest -> IRootComponent.Child.AnotherTest(
                createAnotherTest(
                    componentContext
                )
            )
        }

    private fun createItemList(componentContext: ComponentContext): ListComponent =
        ListComponent(
            componentContext = componentContext,
            onItemSelected = {
                navigation.bringToFront(Config.AnotherTest)
            }
        )

    private fun createItemDetails(componentContext: ComponentContext, config: Config.Details): IDetailsComponent =
        DetailsComponent(
            componentContext = componentContext,
            itemId = config.itemId,
            onFinished = { navigation.pop() }
        )

    private fun createAnotherTest(componentContext: ComponentContext): IAnotherTestComponent =
        AnotherTestComponent(
            componentContext = componentContext,
            onBack = {
                navigation.pop()
            }
        )



    private sealed class Config : Parcelable {
        @Parcelize
        object List : Config()

        @Parcelize
        object AnotherTest : Config()

        @Parcelize
        data class Details(val itemId: Long) : Config()
    }
}
