package com.five.high.emirim.geulgil.geulgil.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.fragment.BlankFragment
import kotlinx.android.synthetic.main.activity_tutorial.*

class TutorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        setupViewPager(pager)

    }
    private fun setupViewPager(pager: ViewPager?){
        val adapter = Adapter(supportFragmentManager)

        adapter.addFragment(BlankFragment.newInstance("tutorial_01.jpg"))
        adapter.addFragment(BlankFragment.newInstance("tutorial_02.jpg"))
        adapter.addFragment(BlankFragment.newInstance("tutorial_03.jpg"))
        adapter.addFragment(BlankFragment.newInstance("tutorial_04.jpg"))

        pager?.adapter = adapter
    }

    private class Adapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        val fragments = ArrayList<Fragment>()
        override fun getItem(position: Int): Fragment = fragments.get(position)

        override fun getCount(): Int = fragments.size

        fun addFragment(fragment: Fragment) {
            fragments.add(fragment)
        }
    }
}
