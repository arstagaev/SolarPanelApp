package com.arstagaev.solarpanelx

import com.arstagaev.solarpanelx.enums.DevPlatform

expect fun getPlatformName(): DevPlatform

expect fun createFiveSlots()

expect suspend fun saveNewBudgetJSON()

expect suspend fun refreshBudgetJSON()

expect suspend fun decodeFromFile()

expect suspend fun getListOfBudgets(): ArrayList<String>