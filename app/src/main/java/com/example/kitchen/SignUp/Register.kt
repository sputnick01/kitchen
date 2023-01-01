package com.example.kitchen.SignUp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.App.Base
import com.example.kitchen.R
import com.example.kitchen.mainPage.Main
import kotlinx.android.synthetic.main.form_register.*
import kotlinx.android.synthetic.main.form_sign_in.*

//import kotlinx.android.synthetic.main.. *

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_register)
        SignUp.setOnClickListener {
            checkValue()
        }

    }


    private fun checkValue() {

        if (reg_edt_password.text.isEmpty()) {
            Toast.makeText(this, "لطفا رمز کاربری را وارد سازید", Toast.LENGTH_LONG).show()
        } else if (reg_edt_name.text.isEmpty()) {
            Toast.makeText(this, "لطفا نام کاربر را وارد سازید", Toast.LENGTH_LONG).show()

        } else if (reg_edt_confirmPass.text.isEmpty()) {
            Toast.makeText(this, "لطفا تکرار رمز کاربری را وارد سازید", Toast.LENGTH_LONG).show()
        } else if (reg_edt_password.text.toString()!=reg_edt_confirmPass.text.toString()
        ) {
            Toast.makeText(this, "رمز کاربر با تکرار آن یکی نیست .", Toast.LENGTH_LONG).show()

        } else {
            Base.sharedPref!!.setNamePref(reg_edt_name.text.toString())
            Base.sharedPref!!.setPhonePref(reg_edt_password.text.toString())
            Base.sharedPref!!.setLogin(true)
            startActivity(Intent(this, Main::class.java))
            finish()
        }

    }


}



