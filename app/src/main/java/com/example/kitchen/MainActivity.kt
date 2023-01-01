package com.example.kitchen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kitchen.fragment.HomeFragment
import com.example.kitchen.fragment.PersonFragment
import com.example.kitchen.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main. *

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.id_frameLayout, HomeFragment()).commit()

        id_btn_nav_view.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.id_bottomNav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.id_frameLayout, HomeFragment()).commit()
                    txt_toolbar.text="خانه"
                }
                R.id.id_bottomNav_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.id_frameLayout, SearchFragment()).commit()
                    txt_toolbar.text="جستوجو"


                }
                R.id.id_bottomNav_person -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.id_frameLayout, PersonFragment()).commit()
                    txt_toolbar.text="پروفایل"

                }

            }

            true

        }
    }
}