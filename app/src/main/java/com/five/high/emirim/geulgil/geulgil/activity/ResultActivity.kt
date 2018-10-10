package com.five.high.emirim.geulgil.geulgil.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.adapter.CardRecyclerAdapter
import com.five.high.emirim.geulgil.geulgil.manager.JsonParser
import com.five.high.emirim.geulgil.geulgil.model.Word
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private val words: ArrayList<Word> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar!!.hide()

        JsonParser.createInstance.parsingJsonObject(words, intent.getStringExtra("word_json"))

        // Creates a vertical Layout Manager
        rv_card_list.layoutManager = LinearLayoutManager(this)

        // Access the RecyclerView Adapter and load the data into it
        rv_card_list.adapter = CardRecyclerAdapter(words, this)

    }
}
