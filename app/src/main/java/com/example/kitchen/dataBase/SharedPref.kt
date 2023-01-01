package com.example.kitchen.dataBase

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    val login = "LOGIN"
    val sharedPref: SharedPreferences = context.getSharedPreferences(login, 0)
    val editor: SharedPreferences.Editor = sharedPref.edit()

    val keyNamePref = "KeyNamePref"
    val keyPhonePref = "KeyPhonePref"

    fun setNamePref(name: String) {
        editor.putString(keyNamePref, name)
        editor.commit()
    }

    fun getNamePref(): String? {
        return sharedPref.getString(keyNamePref,null)
    }

    fun setPhonePref(phone: String) {
        editor.putString(keyPhonePref, phone)
        editor.commit()
    }

    fun getPhone(): String? {
        return sharedPref.getString(keyPhonePref,null)
    }

    val keyLogin = "keyLogin"
    fun setLogin(login: Boolean) {
        editor.putBoolean(keyLogin, login)
        editor.commit()
    }

    fun getLogin(): Boolean? {

        return sharedPref.getBoolean(keyLogin,false)
    }


}