package com.example.kitchen.fragment.tabLayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitchen.Adapter.AdapterFood
import com.example.kitchen.App.Base
import com.example.kitchen.R

class CakeFragment : Fragment() {

    var layoutView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutView = inflater.inflate(R.layout.cake_fragment, container, false)
        cast()
        return layoutView
    }

    var recycler: RecyclerView? = null
    var foodAdapter: AdapterFood? = null
    private fun cast() {
        recycler = layoutView!!.findViewById(R.id.recycler_Cake)
        recycler!!.setHasTransientState(true)
        recycler!!.layoutManager = LinearLayoutManager(Base.activity)
        val list = Base.dataBase!!.getCategory("cake")
        foodAdapter = AdapterFood(Base.activity!!, list)
        recycler!!.adapter = foodAdapter

    }
}