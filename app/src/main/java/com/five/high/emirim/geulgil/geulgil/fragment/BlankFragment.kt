package com.five.high.emirim.geulgil.geulgil.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.five.high.emirim.geulgil.geulgil.R
import kotlinx.android.synthetic.main.fragment_blank.view.*


class BlankFragment : Fragment() {
    var text = ""

    companion object {
        fun newInstance(text: String): BlankFragment {
            val fragment = BlankFragment()
            val bundle = Bundle()
            bundle.putString("Text", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        text = arguments?.get("Text").toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.textView.setText(text)
    }
}