package com.ravimhzn.domainproperties

import android.app.Application
import com.ravimhzn.domainproperties.util.Views
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DomainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //Handle classes that needs to be initialised at the start of app e.g. below:
        Views.init(this)
    }
}