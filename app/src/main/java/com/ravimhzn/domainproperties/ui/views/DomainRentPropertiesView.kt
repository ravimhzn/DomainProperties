package com.ravimhzn.domainproperties.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ravimhzn.domainproperties.model.RentalPropertyResponse
import com.ravimhzn.domainproperties.navigation.Screen
import com.ravimhzn.domainproperties.util.DimensionUtil.contentSpacingSmall
import com.ravimhzn.domainproperties.viewmodel.MainViewModel
import java.io.Serializable

@Composable
fun DomainRentPropertiesView(navHostController: NavHostController, viewModel: MainViewModel) {

    val rentalPropertyData by viewModel.rentalPropertyResponse.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            MyComposeToolbar(onMenuBuyListener = {
                navHostController.navigate(Screen.BUY.route)
            })

            Spacer(
                modifier = Modifier
                    .height(contentSpacingSmall)
            )

            val searchResults = rentalPropertyData.getFilteredSearchResult()
            searchResults?.let {
                LazyColumn {
                    items(it.size) { index ->
                        PropertyRowView(it[index])
                    }
                }
            }
        }
    }
}
