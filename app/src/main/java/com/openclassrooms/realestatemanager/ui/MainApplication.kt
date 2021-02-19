package com.openclassrooms.realestatemanager.ui

import android.app.Application

class MainApplication : Application() {

    lateinit var sApplication: Application

    override fun onCreate() {
        super.onCreate()

        sApplication = this
    }

    fun getApplication(): Application { return sApplication }
}