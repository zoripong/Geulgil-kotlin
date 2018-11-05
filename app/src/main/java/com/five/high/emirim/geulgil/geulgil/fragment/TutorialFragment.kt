package com.five.high.emirim.geulgil.geulgil.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_tutorial.view.*


class TutorialFragment : Fragment() {
    val image = R.drawable.tutorial_01
    var index:Int = 0

    companion object {
        fun newInstance(index: Int): TutorialFragment {
            val fragment = TutorialFragment()
            val bundle = Bundle()
            bundle.putInt("index", index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        index = Integer.parseInt(arguments?.get("index").toString())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tutorial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
                .load(image + index)
                .into(view.iv_tutorial)

        if (index == 3) {
            view.tv_finish.visibility = View.VISIBLE
        } else {
            view.tv_finish.visibility = View.INVISIBLE
        }

        view.tv_finish.setOnClickListener {
            activity!!.finish()
        }
    }

}