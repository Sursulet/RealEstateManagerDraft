package com.openclassrooms.realestatemanager.ui

import android.app.Application

class MainApplication : Application() {

    private lateinit var sApplication: Application

    override fun onCreate() {
        super.onCreate()

        sApplication = this
    }

    fun getApplication(): Application = sApplication
}