package com.five.high.emirim.geulgil.geulgil.manager

import com.five.high.emirim.geulgil.geulgil.model.Word
import com.google.gson.JsonArray
import org.json.JSONArray
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

            val jsonMeanWordsList = word.getJSONArray("mean_keywords")
            val meanWordsList: ArrayList<ArrayList<String>> = ArrayList()
            for(i in 0 until jsonMeanWordsList.length()){
                val jsonMeanWords: JSONArray = jsonMeanWordsList.getJSONArray(i)
                val meanWords: ArrayList<String> = ArrayList()
                for(j in 0 until jsonMeanWords.length()) {
                    meanWords.add(jsonMeanWords.getString(i))
                }
                meanWordsList.add(meanWords)
            }

            val jsonSimilarWords = word.getJSONArray("similar_keywords")
            val similarWords: ArrayList<String> = ArrayList()
            for(i in 0 until jsonSimilarWords.length()){
                similarWords.add(jsonSimilarWords.getString(i))
            }

            list.add(Word(word.getInt("word_id"), word.getString("word"), word.getInt("part"), means, meanWordsList, similarWords))
        }
        return list
    }
}