package com.five.high.emirim.geulgil.geulgil.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_card_single.view.*

/**
 * Created by Mirim on 2018-10-05.
 */
class SingleWordHolder (view: View) : RecyclerView.ViewHolder(view){
    val tvWord = view.tv_single_word
    val tvMean = view.tv_mean
    val liMeanKeywords = view.li_mean_keywords
    val liSimilarKeywords = view.li_similar_keywords
    val liDelete = view.li_delete_single_word
}