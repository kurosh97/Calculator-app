package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onDigit(view: View) {
        val input = findViewById<TextView>(R.id.tvInput);
        input.append((view as Button).text)
    }

    fun onClear(view: View) {
        val input = findViewById<TextView>(R.id.tvInput);
        input.text = ""
    }


}