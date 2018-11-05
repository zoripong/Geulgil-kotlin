package com.five.high.emirim.geulgil.geulgil.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.fragment.TutorialFragment
import kotlinx.android.synthetic.main.activity_tutorial.*

class TutorialActivity : AppCompatActivity() {
    val TUTORIAL_PAGE: Int = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        supportActionBar!!.hide() // Remove Actionbar

        setupViewPager(pager)

    }
    private fun setupViewPager(pager: ViewPager?){
        val adapter = Adapter(supportFragmentManager)

        for( i in 0 until TUTORIAL_PAGE){
            adapter.addFragment(TutorialFragment.newInstance(i))
        }
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
