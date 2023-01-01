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
import java.util.zip.Inflater

class SearchAdapter(val context: Context, var ListFood: ArrayList<Food>) :
    RecyclerView.Adapter<SearchAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout =
            LayoutInflater.from(context).inflate(R.layout.search_layout, parent, false)
        return Holder(layout)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val food = ListFood.get(position)
        val typeface = Typeface.createFromAsset(context.assets, "lalezar.ttf")
        holder.name.setTypeface(typeface)

        holder.name.text = food.nameFood
        Glide.with(context).load(food.image).into(holder.image)
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

        val name = itemview.findViewById<TextView>(R.id.txt_search)
        val image = itemview.findViewById<ImageView>(R.id.image_search)

    }

    fun filter(List : ArrayList<Food>){
        ListFood=List
        notifyDataSetChanged()
    }


}