package com.five.high.emirim.geulgil.geulgil.manager

import com.five.high.emirim.geulgil.geulgil.model.Word
import com.google.gson.JsonArray
import org.json.JSONObject

/**
 * Created by Devuri on 2018-10-05.
 */
class JsonParser {
    private constructor(){}
    companion object {
        private lateinit var instance: JsonParser
        val createInstance: JsonParser
            get() {
                if (instance == null) {
                    instance = JsonParser()
                }

                return instance
            }
    }
    // TODO: Test
    fun parsingJsonObject(list: ArrayList<Word>, stringJson: String): ArrayList<Word>{
        val json = JSONObject(stringJson)
        val searchResult = json.getJSONObject("result").getJSONArray("search_result")
        for(i in 0 until searchResult.length()){
            val word: JSONObject = searchResult.getJSONObject(i)

            val jsonMeans = word.getJSONArray("means")
            val means: ArrayList<String> = ArrayList()
            for(i in 0 until jsonMeans.length()){
                means.add(jsonMeans.getString(i))
            }

            val jsonMeanWords = word.getJSONArray("mean_words")
            val meanWords: ArrayList<String> = ArrayList()
            for(i in 0 until jsonMeanWords.length()){
                meanWords.add(jsonMeanWords.getString(i))
            }

            val jsonSimilarWords = word.getJSONArray("similar_words")
            val similarWords: ArrayList<String> = ArrayList()
            for(i in 0 until jsonSimilarWords.length()){
                similarWords.add(jsonSimilarWords.getString(i))
            }

            list.add(Word(word.getInt("word_id"), word.getString("word"), word.getInt("part"), means, meanWords, similarWords))
        }
        return list
    }
}