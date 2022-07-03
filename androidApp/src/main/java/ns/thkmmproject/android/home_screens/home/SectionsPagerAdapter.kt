package com.ns.tabactivity.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ns.thkmmproject.model.Databean

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, var sectionList : ArrayList<Databean>) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1,sectionList[position].section_id)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return sectionList[position].name
    }

    override fun getCount(): Int {
        return sectionList.size
    }
}