package com.five.high.emirim.geulgil.geulgil.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.alias.HolderType
import com.five.high.emirim.geulgil.geulgil.holder.SamesoundsWrodHolder
import com.five.high.emirim.geulgil.geulgil.holder.SingleWordHolder
import com.five.high.emirim.geulgil.geulgil.model.Word

/**
 * Created by devuri on 2018-10-05.
 */
class CardRecyclerAdapter(private val items : ArrayList<Word>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onBindViewHolder(holder:  RecyclerView.ViewHolder?, position: Int) {
        when{
            holder is SingleWordHolder -> {
                holder.tvWord?.text = items[position].word
//                TODO
            }
            holder is SamesoundsWrodHolder -> {
//                TODO

            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):  RecyclerView.ViewHolder{
        return when (viewType) {
            HolderType.SINGLE_WORD_CARD.ordinal -> SingleWordHolder(LayoutInflater.from(context).inflate(R.layout.item_card_single, parent, false))
            else -> SamesoundsWrodHolder(LayoutInflater.from(context).inflate(R.layout.item_card_samesounds, parent, false))
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when {
            (items[position].means.size > 1) -> HolderType.SINGLE_WORD_CARD.ordinal
            else ->HolderType.SAMESOUNDS_WORD_CARD.ordinal
        }
    }
}
