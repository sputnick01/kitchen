package com.example.kitchen

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.kitchen.App.Base
import com.example.kitchen.dataBase.*
import kotlinx.android.synthetic.main.activity_detail_food.*
import kotlinx.android.synthetic.main.food_layout.*
import kotlinx.android.synthetic.main.main_layout.*

class Detail_Food : AppCompatActivity() {
    var id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)
        val intent: Bundle? = intent.extras
        detail_name_food!!.text = intent!!.getString(key_name)
        txt_description!!.text = intent!!.getString(key_description)
        detail_txt_type_raw_mate!!.text = intent!!.getString(key_type_raw_mate)
        txt_raw_mate!!.text = intent!!.getString(key_raw_mate)
        Glide.with(this).load(intent!!.getString(key_image)).into(Detail_Image_Food)
        id = intent!!.getInt(key_id)
        checkFav(id!!)
        val typeface = Typeface.createFromAsset(applicationContext.assets, "lalezar.ttf")
        detail_name_food.setTypeface(typeface)
        txt_description.setTypeface(typeface)
        detail_txt_type_raw_mate.setTypeface(typeface)
        txt_raw_mate.setTypeface(typeface)
        txt_title1.setTypeface(typeface)
        txt_title2.setTypeface(typeface)

        fav_icon.setOnClickListener {
            addOrRemove(id!!)

        }

    }

    private fun addOrRemove(id: Int) {
        var value=Base.dataBase!!.getValue(id)
        if (value==0){
            fav_icon.setImageResource(R.drawable.ic_baseline_favorite_24)
            Base.dataBase!!.getStatus(1,id)

            Toast.makeText(this,"غذا به لیست علاقه مندی ها اضافه شد.",Toast.LENGTH_LONG).show()
        }else{
            fav_icon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            Base.dataBase!!.getStatus(0,id)
            Toast.makeText(this,"غذا از لیست علاقه مندی ها حذف شد.",Toast.LENGTH_LONG).show()
        }


    }

    private fun checkFav(id: Int) {
        var value = Base.dataBase!!.getValue(id)
        if (value == 0) {
            fav_icon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        } else {
            fav_icon.setImageResource(R.drawable.ic_baseline_favorite_24)
        }

    }
}