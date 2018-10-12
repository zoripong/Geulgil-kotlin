package com.five.high.emirim.geulgil.geulgil.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.alias.HolderType
import com.five.high.emirim.geulgil.geulgil.holder.SamesoundsWrodHolder
import com.five.high.emirim.geulgil.geulgil.holder.SingleWordHolder
import com.five.high.emirim.geulgil.geulgil.model.Word

/**
 * Created by devuri on 2018-10-05.
 */
class CardRecyclerAdapter(private val items : ArrayList<Word>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder:  RecyclerView.ViewHolder?, position: Int) {
        when{
            holder is SingleWordHolder -> {
//              TODO
                holder.tvWord?.text = items[position].word
                holder.tvMean?.text = items[position].means[0]

                for(item in items[position].meanKeywords){
                    holder.liMeanKeywords.addView(Button(context))
                }

                for(item in items[position].similarKeywords) {
                    holder.liSimilarKeywords.addView(Button(context))
                }

                holder.liDelete.setOnClickListener{
                    items.removeAt(position)
                    notifyDataSetChanged()
                }
            }
            holder is SamesoundsWrodHolder -> {
                holder.tvWord?.text = items[position].word
                holder.tvSizeMessage?.text = "외 " + items[position].meanKeywords.size.toString() +"개의 결과"
                holder.liDelete.setOnClickListener{
                    items.removeAt(position)
                    notifyDataSetChanged()
                }
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
