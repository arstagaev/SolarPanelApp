package com.arstagaev.solarpanelx.data.remote

object NetworkConstants {
    const val baseUrl1 = "https://api.weatherapi.com/v1/current.json?"
    const val apiKey = "038b220f8d1d443799f162217230306"

    //https://api.weatherapi.com/v1/current.json?key=038b220f8d1d443799f162217230306&q=Saratov&aqi=no
    object City {
        const val route = baseUrl1 + "key=$apiKey&q="
        val byName: (String) -> String = { name -> "$route$name&aqi=no"}
    }

}