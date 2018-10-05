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
import com.five.high.emirim.geulgil.geulgil.alias.SearchType
import com.five.high.emirim.geulgil.geulgil.network.RetrofitService
import com.five.high.emirim.geulgil.geulgil.network.model.Word
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_box.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
                    val retrofitService = RetrofitService.create()
                    when(sp_word_type.selectedItemPosition){
                        SearchType.BASIC_SEARCH.ordinal -> {
                            // 포괄 검색
                            retrofitService.search(word).enqueue(object : Callback<Word> {
                                override fun onResponse(call: Call<Word>?, response: Response<Word>?) {
                                    if (response != null && response.isSuccessful) {
                                        Log.e(tag, "성공")
                                    } else {
                                        Log.e(tag, "실패")
                                    }
                                }

                                override fun onFailure(call: Call<Word>?, t: Throwable?) {
                                }
                            })


                        }
                        SearchType.MEAN_SEARCH.ordinal -> {
                            // 포함어 검색
                            retrofitService.searchInMean(word)
                        }
                        SearchType.SIMILAR_SEARCH.ordinal -> {
                            // 유사어 검색
                            retrofitService.searchInSimilar(word)
                        }

                    }



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
