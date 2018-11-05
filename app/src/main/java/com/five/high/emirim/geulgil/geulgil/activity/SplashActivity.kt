package com.five.high.emirim.geulgil.geulgil.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.five.high.emirim.geulgil.geulgil.R

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

        val sharedPreference =  getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        val isFirstUser:Boolean = sharedPreference.getBoolean("isFirstUser", true)
        Log.e(TAG, "isFirstUser is$isFirstUser")
        Handler().postDelayed({
            var intent = Intent(this@SplashActivity, MainActivity::class.java)
            if(isFirstUser){
                var editor = sharedPreference.edit()
                editor.putBoolean("isFirstUser", false)
                editor.apply()
                intent = Intent(this@SplashActivity, TutorialActivity::class.java)
            }
            startActivity(intent)
            finish()
        }, 3000)
    }
}