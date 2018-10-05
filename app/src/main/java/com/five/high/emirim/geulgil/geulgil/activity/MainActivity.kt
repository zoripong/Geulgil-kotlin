package com.five.high.emirim.geulgil.geulgil.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Editable
import android.util.Log
import com.five.high.emirim.geulgil.geulgil.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_box.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private val tag: String = "MainActivity"

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setBackgroundDrawableResource(R.drawable.bg_basic)
        et_searchBox.text = Editable.Factory.getInstance().newEditable("사랑  ?")
        iv_searchBtn.setOnClickListener {
//            var word = et_searchBox.getText().toString()
            var word : String= et_searchBox.text.toString()

            when {
                checkForm(word) -> {
                    // 한글이 아닌 문자를 입력
                    Log.e(tag, "한글이 아닙니다.")
                }
                word.isEmpty() -> {
                    // 아무것도 입력하지 않음.
                    Log.e(tag, "입력해주세요.")
                }
                else -> {
                    word = word.replace(" ", "")
                    Log.e(tag, "검색합니다. : ${word} / 타입은 : ${sp_word_type.selectedItemPosition}")
                }
            }


        }

        iv_question_mark.imageAlpha = 50
        iv_question_mark.setOnClickListener {
            startActivity(Intent(this@MainActivity, IntroActivity::class.java))
        }

    }

    private fun checkForm(str: String): Boolean {
        val result = Pattern.matches("^[a-zA-Z0-9]*$", str)
        return str.isNotEmpty() && result
    }
}
