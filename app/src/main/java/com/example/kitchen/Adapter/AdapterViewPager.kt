package com.example.kitchen.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdapterViewPager(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    var fragmentList: ArrayList<Fragment> = ArrayList()
    var titleList: ArrayList<String> = ArrayList()
    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {

        return fragmentList.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }
    fun setFragment(fragment: Fragment,title :String){
        fragmentList.add(fragment)
        titleList.add(title)
    }



}
