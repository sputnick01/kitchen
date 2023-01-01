package com.example.kitchen.mainPage

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kitchen.Adapter.AdapterViewPager
import com.example.kitchen.App.Base
import com.example.kitchen.R
import com.example.kitchen.dataBase.DataBase
import com.example.kitchen.fragment.HomeFragment
import com.example.kitchen.fragment.PersonFragment
import com.example.kitchen.fragment.SearchFragment
import kotlinx.android.synthetic.main.main_layout.*

class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment())
            .commit()
        val typeface = Typeface.createFromAsset(applicationContext.assets, "lalezar.ttf")
        txt_category_fragment.setTypeface(typeface)

        Base.dataBase = DataBase(this)
        Base.activity = this

        btn_navigation_view.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.id_bottomNav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, HomeFragment()).commit()
                    txt_category_fragment.text = "خانه"

                }
                R.id.id_bottomNav_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SearchFragment()).commit()
                    txt_category_fragment.text = "جستوجو"
                }
                R.id.id_bottomNav_person -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, PersonFragment()).commit()
                    txt_category_fragment.text = "شخصی"
                }


            }


            true
        }


    }

    override fun onBackPressed() {
    }
}