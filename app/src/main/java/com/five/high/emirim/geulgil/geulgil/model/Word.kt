package com.five.high.emirim.geulgil.geulgil.model

/**
 * Created by Mirim on 2018-10-05.
 */
data class Word(
        val wordId: Int,
        val word: String,
        val part: Int,
        val means: ArrayList<String>,
        val meanKeywords: ArrayList<ArrayList<String>>,
        val similarKeywords: ArrayList<String>
)
