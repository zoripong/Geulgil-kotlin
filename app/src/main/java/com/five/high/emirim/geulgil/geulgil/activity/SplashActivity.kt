package com.five.high.emirim.geulgil.geulgil.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.five.high.emirim.geulgil.geulgil.R
import com.five.high.emirim.geulgil.geulgil.dialog.NetworkExceptionDialog
import com.five.high.emirim.geulgil.geulgil.manager.JsonParser
import com.five.high.emirim.geulgil.geulgil.network.RetrofitService
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Devuri on 2018-10-05.
 */
class SplashActivity : AppCompatActivity() {
    private val PREF_NAME = "TUTORIAL"
    private val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar!!.hide() // 액션바 숨기기

        // val for tutorial
        val sharedPreference =  getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        val isFirstUser:Boolean = sharedPreference.getBoolean("isFirstUser", true)

        val retrofitService = RetrofitService.create()
        retrofitService.networkTest().enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                if (response != null && response.isSuccessful) {
                    val body : JsonObject = response.body()!!
                    if(body.get("status").asString == "ok"){
                        Handler().postDelayed({
                            var intent = Intent(this@SplashActivity, MainActivity::class.java)
                            startActivity(intent)
                            if(isFirstUser){
                                var editor = sharedPreference.edit()
                                editor.putBoolean("isFirstUser", false)
                                editor.apply()
                                intent = Intent(this@SplashActivity, TutorialActivity::class.java)
                                startActivity(intent)
                            }
                            finish()
                        }, 3000)
                    }else{
                        failConnectingNetwork()
                    }
                } else {
                    failConnectingNetwork()
                }
            }
            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                failConnectingNetwork()
            }
        })
    }
    fun failConnectingNetwork(){
        Thread(Runnable {
            NetworkExceptionDialog.createInstance.showDialog(this, "야호")
        }).start()
    }
}