package com.ravimhzn.domainproperties

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DomainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //Handle classes that needs to be initialised at the start of app
    }
}