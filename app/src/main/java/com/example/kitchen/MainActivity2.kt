package com.example.kitchen

import android.R
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main. *
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kitchen.R.layout.activity_main2)

        overridePendingTransition(0, 0)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        activity_main_id.startAnimation(animation)
    }
}