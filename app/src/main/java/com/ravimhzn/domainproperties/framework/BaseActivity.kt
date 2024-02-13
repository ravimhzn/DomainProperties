package com.ravimhzn.domainproperties.framework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

open class BaseActivity<ChildViewModel : BaseViewModel> : ComponentActivity(), DataObserver {

    lateinit var viewModel: ChildViewModel

    open fun getViewModelClass(): Class<ChildViewModel> {
        return genericType(ViewModel::class.java) as Class<ChildViewModel>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this)[getViewModelClass()]
        lifecycleScope.launch {
            registerObservers(viewModel)
        }
    }

    fun genericType(classType: Class<*>): Type? {
        var currentClass: Class<*>? = javaClass
        while (currentClass != null) {
            currentClass.genericSuperclass?.let { superclass ->
                if (superclass is ParameterizedType) {
                    superclass.actualTypeArguments.forEach { argument ->
                        if (argument is Class<*> && classType.isAssignableFrom(argument)) {
                            return argument
                        }
                    }
                }
            }
            currentClass = currentClass.superclass
        }
        return null
    }
}
