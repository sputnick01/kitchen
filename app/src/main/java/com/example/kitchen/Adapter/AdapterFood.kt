package com.example.kitchen.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitchen.Detail_Food
import com.example.kitchen.R
import com.example.kitchen.dataBase.*
import com.example.kitchen.model.Food
import kotlinx.android.synthetic.main.main_layout.*
import java.util.zip.Inflater

class AdapterFood(val context: Context, val ListFood: ArrayList<Food>) :
    RecyclerView.Adapter<AdapterFood.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout = LayoutInflater.from(context).inflate(R.layout.food_layout, parent, false)
        return Holder(layout)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {


        val food = ListFood.get(position)
        val typeface = Typeface.createFromAsset(context.assets, "lalezar.ttf")
        holder.txtNameFood.setTypeface(typeface)
        holder.txtDescriptionFood.setTypeface(typeface)

        holder.txtNameFood.text = food.nameFood
        holder.txtDescriptionFood.text = food.description
        Glide.with(context).load(food.image).into(holder.imageFood)
        holder.itemView.setOnClickListener {

            val intent = Intent(context, Detail_Food::class.java)
            intent.putExtra(key_name, food.nameFood)
            intent.putExtra(key_description, food.description)
            intent.putExtra(key_image, food.image)
            intent.putExtra(key_type_raw_mate, food.typeRawMat)
            intent.putExtra(key_raw_mate, food.rawMat)
            intent.putExtra(key_id, food.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return ListFood.size
    }

    class Holder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val txtNameFood = itemview.findViewById<TextView>(R.id.name_food)
        val txtDescriptionFood = itemview.findViewById<TextView>(R.id.description_food)
        val imageFood = itemview.findViewById<ImageView>(R.id.image_food)
        val cardview = itemview.findViewById<CardView>(R.id.cardview_adapter)

    }

}