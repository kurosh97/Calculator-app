package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onDigit(view: View) {
        val input: TextView = findViewById<TextView>(R.id.tvInput);
        lastNumeric = true
        input.append((view as Button).text)


    }

    fun onClear(view: View) {
        val input: TextView = findViewById<TextView>(R.id.tvInput);
        lastNumeric = false
        lastDot = false;
        input.text = ""
    }

    fun onDesimalPoint(view: View) {
        val input: TextView = findViewById<TextView>(R.id.tvInput);
        if (lastNumeric && !lastDot) {
            input.append(".")
            lastNumeric = false
            lastDot = true;
        }
    }

    fun onEqual(view: View) {
        val input: TextView = findViewById<TextView>(R.id.tvInput);
        if (lastNumeric) {
            var tvValue = input.text.toString()
            var preFix = ""

            try {
                if (preFix.startsWith("-")) {
                    preFix = "-"
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (!preFix.isEmpty()) {
                        one = preFix + one
                    }
                    input.text = (one.toDouble() - two.toDouble()).toString()
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }

    }


    fun onOperator(view: View) {
        val input: TextView = findViewById<TextView>(R.id.tvInput);
        if (lastNumeric && !isOperationAdded(input.text.toString())) {
            input.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    private fun isOperationAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }


}