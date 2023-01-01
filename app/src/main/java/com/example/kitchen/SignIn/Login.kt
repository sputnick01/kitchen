package com.example.kitchen.SignIn

import android.content.Intent
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen.App.Base
import com.example.kitchen.R
import com.example.kitchen.SignUp.Register
import com.example.kitchen.dataBase.SharedPref
import com.example.kitchen.mainPage.Main
import kotlinx.android.synthetic.main.form_register.*
import kotlinx.android.synthetic.main.form_sign_in.*


class Login : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_sign_in)
        CheakRegister()
        id_txtGotoReg.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        submit.setOnClickListener(this)
    }

    private fun CheakRegister() {
        var flag:Boolean=false
        Base.sharedPref= SharedPref(this)
        Toast.makeText(this,"${Base.sharedPref!!.getLogin()!!}",Toast.LENGTH_LONG).show()
        flag = Base.sharedPref!!.getLogin()!!
        if (flag == true) {
            startActivity(Intent(this, Main::class.java))
            finish()
        }

    }


    private fun checkValue() {

        if (id_password_login.text.isEmpty()) {
            Toast.makeText(this, "لطفا رمز کاربری را وارد سازید", Toast.LENGTH_LONG).show()
        } else if (id_name_login.text.isEmpty()) {
            Toast.makeText(this, "لطفا نام کاربر را وارد سازید", Toast.LENGTH_LONG).show()

        } else {
            var name = Base.sharedPref!!.getNamePref()
            var password = Base.sharedPref!!.getPhone()
            var flag = true
            if (name != id_name_login.text.toString()) {
                flag = false
                Toast.makeText(this, "نام کاربر اشتباه است!", Toast.LENGTH_LONG).show()

            }
            if (password != id_password_login.text.toString()) {
                flag = false
                Toast.makeText(this, "رمز کاربر اشتباه است!", Toast.LENGTH_LONG).show()

            }
            if (flag) {
                startActivity(Intent(this, Main::class.java))
                finish()
            }
        }
    }


    override fun onClick(p0: View?) {

        when (p0) {
            submit -> {
                checkValue()
            }
        }
    }


}