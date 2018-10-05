package com.five.high.emirim.geulgil.geulgil.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.adapter.CardRecyclerAdapter
import com.five.high.emirim.geulgil.geulgil.model.Word
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private val words: ArrayList<Word> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar!!.hide()

        // FIXME : for test
        addWords()

        // Creates a vertical Layout Manager
        rv_card_list.layoutManager = LinearLayoutManager(this)

        // Access the RecyclerView Adapter and load the data into it
        rv_card_list.adapter = CardRecyclerAdapter(words, this)

    }
    private fun addWords(){
        words.add(Word("사랑", "사랑의 의미"))
        words.add(Word("사람", "사람의 의미"))
        words.add(Word("인생", "인생의 의미"))
    }
}
