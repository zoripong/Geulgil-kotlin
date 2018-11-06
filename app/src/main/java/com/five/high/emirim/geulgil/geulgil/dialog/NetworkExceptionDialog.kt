package com.five.high.emirim.geulgil.geulgil.dialog

import android.app.Activity
import android.app.AlertDialog
import android.widget.Toast
import com.five.high.emirim.geulgil.geulgil.R
import kotlinx.android.synthetic.main.dialog_network_exception.view.*


class NetworkExceptionDialog {
    private constructor()
    companion object {
        private lateinit var instance: NetworkExceptionDialog
        val createInstance: NetworkExceptionDialog
            get() {
                if (instance == null) {
                    instance = NetworkExceptionDialog()
                }
                return instance
            }
    }
    fun showDialog(activity :Activity, message: String){
        val builder = AlertDialog.Builder(activity)
        val dialogView = activity.layoutInflater.inflate(R.layout.dialog_network_exception, null)
        builder.setView(dialogView)

        dialogView.tv_guide_message.text = message
        dialogView.btn_retry.setOnClickListener {
            Toast.makeText(activity.applicationContext, message, Toast.LENGTH_LONG).show()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }


}