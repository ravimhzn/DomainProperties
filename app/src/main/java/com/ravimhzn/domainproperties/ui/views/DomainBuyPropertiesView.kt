package com.ravimhzn.domainproperties.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ravimhzn.domainproperties.framework.State
import com.ravimhzn.domainproperties.model.PropertyResponse
import com.ravimhzn.domainproperties.util.DimensionUtil
import com.ravimhzn.domainproperties.util.StringUtils
import com.ravimhzn.domainproperties.viewmodel.MainViewModel

@Composable
fun DomainBuyPropertiesView(viewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MyComposeToolbar(appTitle = StringUtils.appTitleBuy, displayMenu = false)

            Spacer(modifier = Modifier.height(DimensionUtil.contentSpacing))

            val mutableStateData by viewModel.uiState.collectAsState()

            when (mutableStateData) {
                is State.Loaded -> {
                    if ((mutableStateData as State.Loaded).data is PropertyResponse) {
                        //Todo
                    }
                }

                else -> {

                }
            }
        }
    }
}
