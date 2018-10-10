package com.five.high.emirim.geulgil.geulgil.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.model.Word

/**
 * Created by devuri on 2018-10-05.
 */
class CardRecyclerAdapter(private val items : ArrayList<Word>, private val context: Context) : RecyclerView.Adapter<CardViewHolder>(){
    override fun onBindViewHolder(holder: CardViewHolder?, position: Int) {
        holder?.tvWord?.text = items[position].word
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cardview, parent, false))
    }
}
