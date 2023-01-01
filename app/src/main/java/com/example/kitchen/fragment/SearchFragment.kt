package com.example.kitchen.fragment

import android.content.Context
import android.graphics.Typeface
import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitchen.Adapter.SearchAdapter
import com.example.kitchen.App.Base
import com.example.kitchen.R
import com.example.kitchen.dataBase.DataBase
import com.example.kitchen.model.Food
import kotlinx.android.synthetic.main.layout_fragment_search.*
import kotlinx.android.synthetic.main.nosearch_data.*

class SearchFragment() : Fragment() {

    var layoutView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutView = inflater.inflate(R.layout.layout_fragment_search, container, false)

        cast()
        return layoutView
    }


    var recyclerView: RecyclerView? = null
    var editText: EditText? = null
    var Listse: ArrayList<Food>? = null
    var adaptersearch: SearchAdapter? = null
    var relativeLayout: RelativeLayout? = null
    fun cast() {

        recyclerView = layoutView!!.findViewById(R.id.search_recycler)
        editText = layoutView!!.findViewById(R.id.search_edtText)
        val myFont: Typeface = Typeface.createFromAsset(requireContext().assets, "lalezar.ttf")
        editText!!.typeface = myFont
        relativeLayout = layoutView!!.findViewById(R.id.layout_noItem)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = GridLayoutManager(Base.activity!!, 2)
        Listse = Base.dataBase!!.getAll()
        adaptersearch = SearchAdapter(Base.activity!!, Listse!!)
        recyclerView!!.adapter = adaptersearch
        recyclerView!!.visibility = View.GONE
        relativeLayout!!.visibility = View.VISIBLE
        editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                if (p0.toString().isEmpty()) {
                    recyclerView!!.visibility = View.GONE
                    relativeLayout!!.visibility = View.VISIBLE


                } else {
                    recyclerView!!.visibility = View.VISIBLE
                    relativeLayout!!.visibility = View.GONE

                    filterData(p0.toString())
                }

            }


        })
    }

    fun filterData(string: String) {
        val listSearch = ArrayList<Food>()
        for (food: Food in Listse!!) {
            if (food.nameFood!!.toLowerCase().contains(string)) {
                listSearch.add(food)
            }

        }
        adaptersearch!!.filter(listSearch)

    }


}