package com.example.kitchen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.kitchen.SignIn.Login
import kotlinx.android.synthetic.main.activity_main. *
import kotlinx.android.synthetic.main.activity_splash_screen2.*

class SplashScreen2 : AppCompatActivity() {
    private var isFirstAnimation = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        val translateScale: Animation = AnimationUtils.loadAnimation(this, R.anim.translate_scale)
        val hold: Animation = AnimationUtils.loadAnimation(this, R.anim.hold)
        translateScale.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                if (!isFirstAnimation) {
                    header_icon2.clearAnimation()
                    val intent = Intent(this@SplashScreen2, Login::class.java)
                    startActivity(intent)
                    finish()
                }
                isFirstAnimation = true
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        hold.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                header_icon2.clearAnimation()
                header_icon2.startAnimation(translateScale)
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        header_icon2.startAnimation(hold)
    }
    }
