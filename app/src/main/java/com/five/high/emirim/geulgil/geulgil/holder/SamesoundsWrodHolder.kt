package com.five.high.emirim.geulgil.geulgil.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_card_samesounds.view.*
import kotlinx.android.synthetic.main.item_card_single.view.*

/**
 * Created by Mirim on 2018-10-05.
 */
class SamesoundsWrodHolder (view: View) : RecyclerView.ViewHolder(view){
    val tvWord = view.tv_samesounds_word
    val tvSizeMessage = view.tv_size_message
    val liDelete = view.li_delete_samesounds_word
}