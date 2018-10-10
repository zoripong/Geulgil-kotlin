package com.five.high.emirim.geulgil.geulgil.activity

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.alias.SearchType
import com.five.high.emirim.geulgil.geulgil.network.RetrofitService
import com.google.gson.JsonObject
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

        supportActionBar!!.hide()

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
                            retrofitService.search(word).enqueue(object : Callback<JsonObject> {
                                override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                                    if (response != null && response.isSuccessful) {
                                        Log.e(tag, "성공 : ${response.body()}")
                                        if (response.body() != null && !response.body().toString().isEmpty()){
                                            val intent = Intent(this@MainActivity, ResultActivity::class.java)
                                            intent.putExtra("word_json", response.body().toString())
                                            startActivity(intent)
                                        }else{
                                            Toast.makeText(applicationContext, "서버에 문제가 발생하였습니다.", Toast.LENGTH_LONG).show()
                                        }

                                    } else {
                                        Log.e(tag, "실패")
                                    }
                                }
                                override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                                    Toast.makeText(applicationContext, "인터넷을 연결해주세요.", Toast.LENGTH_LONG).show()

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
