package com.ravimhzn.domainproperties.framework

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class BaseActivity: AppCompatActivity(), DataObserver {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo
    }

    fun registerStateObservers(baseViewModel: BaseViewModel){
        lifecycleScope.launch {
            registerObservers(baseViewModel)
        }
    }
}