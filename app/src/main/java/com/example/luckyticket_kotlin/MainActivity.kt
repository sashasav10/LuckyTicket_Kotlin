package com.example.luckyticket_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.check_button).setOnClickListener {
            checkIsLucky()
        }
    }
    @SuppressLint("CutPasteId")
    private fun checkIsLucky(){
        val lampImage= findViewById<ImageView>(R.id.lamp_image)
        val inputNumber= findViewById<EditText>(R.id.ticket_number_editText).text
        if(inputNumber.length<6) {
            findViewById<EditText>(R.id.ticket_number_editText).error= getString(R.string.errorMessage)

        }
        else {
            val leftPart=inputNumber.substring(0,3).toList().sumOf {  "$it".toInt()  }
            val rightPart=inputNumber.substring(3,6).toList().sumOf {  "$it".toInt()  }
            if(leftPart==rightPart) {
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        lampImage.setImageResource(R.drawable.gray_lamp_image)
                    },
                    5000)
                lampImage.setImageResource(R.drawable.green_lamp_image)
                Toast.makeText(this, "That's a lucky ticket!",Toast.LENGTH_LONG).show()
            }
            else {
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        lampImage.setImageResource(R.drawable.gray_lamp_image)
                    },
                    5000)
                lampImage.setImageResource(R.drawable.red_lamp_image)
                Toast.makeText(this, "That's not a lucky ticket(",Toast.LENGTH_LONG).show()
            }
        }
    }
}