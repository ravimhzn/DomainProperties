package com.ravimhzn.domainproperties.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ravimhzn.domainproperties.ui.views.DomainBuyPropertiesView
import com.ravimhzn.domainproperties.ui.views.DomainRentPropertiesView
import com.ravimhzn.domainproperties.viewmodel.MainViewModel

@Composable
fun SetUpNavGraph(navController: NavHostController, viewModel: MainViewModel) {

    NavHost(navController = navController, startDestination = Screen.RENT.route, route = "root") {
        composable(Screen.RENT.route) {
            DomainRentPropertiesView(navController, viewModel)
        }

        composable(Screen.BUY.route) {
            DomainBuyPropertiesView(viewModel)
        }
    }
}