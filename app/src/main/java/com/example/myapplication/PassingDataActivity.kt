package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class PassingDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_passing_data)

        // Find all views
        val fullNameInput = findViewById<TextInputLayout>(R.id.fullName).editText
        val emailInput = findViewById<TextInputLayout>(R.id.email).editText
        val passwordInput = findViewById<TextInputLayout>(R.id.password).editText
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val checkBoxTerms = findViewById<CheckBox>(R.id.checkBox)
        val signupButton = findViewById<Button>(R.id.buttonSignup)

        // Set up the Spinner adapter
        val spinnerCountry = findViewById<Spinner>(R.id.spinnerCountry)
        val countriesAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries_array,
            android.R.layout.simple_spinner_item
        )
        countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountry.adapter = countriesAdapter

        //Add event
        signupButton.setOnClickListener {
            val fullname = fullNameInput?.text?.toString().orEmpty()
            val intent = Intent(this, PassedActivity::class.java)

            //key-value pair
            intent.putExtra("fullName", fullname)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}