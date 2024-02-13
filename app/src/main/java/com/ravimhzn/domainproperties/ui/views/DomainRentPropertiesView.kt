package com.ravimhzn.domainproperties.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ravimhzn.domainproperties.framework.State
import com.ravimhzn.domainproperties.model.PropertyResponse
import com.ravimhzn.domainproperties.util.DimensionUtil.contentSpacing
import com.ravimhzn.domainproperties.viewmodel.MainViewModel

@Composable
fun DomainRentPropertiesView(navHostController: NavHostController, viewModel: MainViewModel) {
    viewModel.getPropertyResponse()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MyComposeToolbar(onMenuRentListener = {}, onMenuBuyListener = {})

            Spacer(modifier = Modifier.height(contentSpacing))

            ComposeDataObserver(navHostController, viewModel)
        }
    }
}

@Composable
fun ComposeDataObserver(navHostController: NavHostController, viewModel: MainViewModel) {

    val mutableStateData by viewModel.uiState.collectAsState()

    when (mutableStateData) {
        is State.Loading -> {
            //Todo loading
        }

        is State.Loaded -> {
            SetUpLazyPropertyList(
                (mutableStateData as State.Loaded).data as PropertyResponse
            )
        }

        is State.Error -> {

        }

        else -> {
            viewModel.emptyState()
        }
    }

}

@Composable
fun SetUpLazyPropertyList(
    response: PropertyResponse
) {
    LazyColumn {

        // Show the entire list initially
        items(response.search_results.size) { index ->
            PropertyRowView(response.search_results[index])

            //Todo remove
            if (index < response.search_results.size - 1) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = Color.Gray
                )
            }
        }
    }
}
