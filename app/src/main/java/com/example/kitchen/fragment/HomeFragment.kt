package com.example.kitchen.fragment

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.kitchen.Adapter.AdapterViewPager
import com.example.kitchen.R
import com.example.kitchen.fragment.tabLayout.BreakFastFragment
import com.example.kitchen.fragment.tabLayout.CakeFragment
import com.example.kitchen.fragment.tabLayout.DinnerFragment
import com.example.kitchen.fragment.tabLayout.LunchFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import kotlinx.android.synthetic.main.layout_fragment_home.*
import java.util.zip.Inflater

class HomeFragment() : Fragment() {


    var layoutView: View? = null
    var tabLayout: TabLayout? = null
    var viewpager: ViewPager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.layout_fragment_home, container, false)

        tabLayout = layoutView!!.findViewById(R.id.tab_layout)
        viewpager = layoutView!!.findViewById(R.id.view_pager)
        adapter()

        return layoutView
    }

    private fun adapter() {
        val adapterViewPager = AdapterViewPager(childFragmentManager)
        adapterViewPager.setFragment(BreakFastFragment(), "صبحانه")
        adapterViewPager.setFragment(LunchFragment(), "نهار")
        adapterViewPager.setFragment(DinnerFragment(), "شام")
        adapterViewPager.setFragment(CakeFragment(), "کیک")
        viewpager!!.adapter = adapterViewPager
        tabLayout!!.setupWithViewPager(viewpager)

    }
}