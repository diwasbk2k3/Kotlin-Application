package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PassedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_passed)

        val displayName = findViewById<TextView>(R.id.displayName)
        val backButton = findViewById<Button>(R.id.backButton)

        val intentObj = intent //getIntent
        val getFullName = intentObj.getStringExtra("fullName")

        displayName.text = getFullName

        backButton.setOnClickListener {
            val previousIntent = Intent(this, PassingDataActivity::class.java)
            startActivity(previousIntent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}