package com.example.kitchen.App

import android.app.Activity
import android.app.Application
import com.example.kitchen.dataBase.DataBase
import com.example.kitchen.dataBase.SharedPref

object Base : Application() {
    var dataBase: DataBase? = null
    var activity: Activity? = null
    var sharedPref: SharedPref? = null
    override fun onCreate() {
        super.onCreate()
    }
}