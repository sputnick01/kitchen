package com.example.kitchen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitchen.Adapter.SearchAdapter
import com.example.kitchen.App.Base
import com.example.kitchen.R
import kotlinx.android.synthetic.main.layout_fragment_person.*

class PersonFragment() : Fragment() {

    var layoutView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutView = inflater.inflate(R.layout.layout_fragment_person, container, false)
        cast()
        return layoutView
    }

    private fun cast() {
        val recyclerPerson: RecyclerView = layoutView!!.findViewById(R.id.recycler_person)
        recyclerPerson.setHasFixedSize(true)
        recyclerPerson.layoutManager = GridLayoutManager(Base.activity, 2)
        var List = Base.dataBase!!.getFav()
        var adapterfav = SearchAdapter(Base.activity!!, List)
        recyclerPerson.adapter = adapterfav

    }
}