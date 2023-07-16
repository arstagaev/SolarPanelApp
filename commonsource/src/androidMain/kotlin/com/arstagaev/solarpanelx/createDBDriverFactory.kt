package com.arstagaev.solarpanelx

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.arstagaev.solarpanelx.util.Constants.nameDB
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

//actual fun Scope.sqlDriverFactory(): SqlDriver {
//    return AndroidSqliteDriver(WeatherDatabase.Schema, androidContext(), "${nameDB}.db")
//}
