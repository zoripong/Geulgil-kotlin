package com.five.high.emirim.geulgil.geulgil.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.five.high.emirim.geulgil.geulgil.R
import kotlinx.android.synthetic.main.fragment_blank.view.*


class BlankFragment : Fragment() {
    var image = R.drawable.tutorial_01

    companion object {
        fun newInstance(index: Int): BlankFragment {
            val fragment = BlankFragment()
            val bundle = Bundle()
            bundle.putInt("index", index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        image += Integer.parseInt(arguments?.get("index").toString())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
                .load(image)
                .into(view.iv_tutorial)
    }
}