package com.ravimhzn.domainproperties

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ravimhzn.domainproperties.framework.BaseActivity
import com.ravimhzn.domainproperties.navigation.SetUpNavGraph
import com.ravimhzn.domainproperties.ui.theme.DomainPropertiesTheme
import com.ravimhzn.domainproperties.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DomainPropertiesTheme {
                navController = rememberNavController()
                SetUpNavGraph(navController, viewModel)
            }
        }
    }
}