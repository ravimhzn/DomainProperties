package com.ravimhzn.domainproperties.navigation

sealed class Screen(val route: String) {
    data object RENT : Screen("RENT")
    data object BUY : Screen("BUY")
}