package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
     lateinit var viewText: TextView
     lateinit var radioGroup: RadioGroup
     lateinit var checkBox1: CheckBox
     lateinit var checkBox2: CheckBox
     lateinit var checkBox3: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewText = findViewById(R.id.inputNama)
        radioGroup = findViewById(R.id.genderRG)
        checkBox1 = findViewById(R.id.checkCoding)
        checkBox2 = findViewById(R.id.checkReading)
        checkBox3 = findViewById(R.id.checkTravelling)
    }

    fun onSendClick(view: View) {
        // Get the text from the TextView
        val viewTextValue = viewText.text.toString()

        // Get the selected value from the RadioGroup
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        var radioValue = ""
        if (selectedRadioButtonId != -1) {
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            radioValue = selectedRadioButton.text.toString()
        }

        // Get the checked state of the CheckBoxes
        val checkBox1Value = if (checkBox1.isChecked) "Coding" else ""
        val checkBox2Value = if (checkBox2.isChecked) "Reading" else ""
        val checkBox3Value = if (checkBox3.isChecked) "Travelling" else ""

        val checkedValues = listOf(checkBox1Value, checkBox2Value, checkBox3Value)
        val hobiText = checkedValues.filter { it.isNotEmpty() }.joinToString(", ")

        // Create an intent to start the second activity
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("viewText", viewTextValue)
        intent.putExtra("radioValue", radioValue)
        intent.putExtra("hobiText", hobiText)
//        intent.putExtra("checkBox1Value", checkBox1Value)
//        intent.putExtra("checkBox2Value", checkBox2Value)
//        intent.putExtra("checkBox3Value", checkBox3Value)
        startActivity(intent)
    }
}
