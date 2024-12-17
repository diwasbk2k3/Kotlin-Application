package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.num1)
        val number2 = findViewById<EditText>(R.id.num2)
        val add = findViewById<Button>(R.id.addition)
        val result = findViewById<TextView>(R.id.result)

        add.setOnClickListener{
            val num1  = number1.text.toString().toInt()
            val num2 = number2.text.toString().toInt()
            val sum = num1 + num2
            result.text = "Sum is $sum"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}