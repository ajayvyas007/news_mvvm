package com.ajay.tech.news.utils

import android.content.Context
import android.graphics.PorterDuff
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.ajay.tech.news.R


/**
 * Created by Ajay Vyas on 20/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
object Toaster {

    fun show(context: Context, message: CharSequence){
        val toast = android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT)
        toast.view.background.setColorFilter(
            ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_IN
        )
        val textView = toast.view.findViewById(android.R.id.message) as TextView
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        toast.show()
    }
}