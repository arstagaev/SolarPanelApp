package com.arstagaev.solarpanelx.data.local.models.shared_pref

import kotlinx.serialization.Serializable

@Serializable
data class SaveContainer(
    val config: SaldoConfiguration,
    val data: ArrayList<MonthSaldo>
)

@Serializable
data class SaldoConfiguration(
    var investmentsAmount: Int,
    var investmentsName: String,
    var startedDateMonth: Int,
    var startedDateYear: Int,
    var currentCurrency: String = "₽"
)

@Serializable
data class MonthSaldo(var incomes: ArrayList<SaldoCell>, var expenses: ArrayList<SaldoCell>)

@Serializable
data class SaldoCell(var amount: Int, var name: String = "", var isConst: Boolean = false)