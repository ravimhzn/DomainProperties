package com.ravimhzn.domainproperties

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ravimhzn.domainproperties.framework.BaseActivity
import com.ravimhzn.domainproperties.navigation.SetUpNavGraph
import com.ravimhzn.domainproperties.viewmodel.VoidViewModel
import com.ravimhzn.domainproperties.ui.theme.DomainPropertiesTheme
import com.ravimhzn.domainproperties.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<VoidViewModel>() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DomainPropertiesTheme {
                navController = rememberNavController()
                SetUpNavGraph(navController)
            }
        }
    }
}