package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val viewTextValue = intent.getStringExtra("viewText")
        val radioValue = intent.getStringExtra("radioValue")
        val checkBoxValueText = findViewById<TextView>(R.id.viewHobi)
        //val checkBox1Value = intent.getStringExtra("checkBox1Value")
        //val checkBox2Value = intent.getStringExtra("checkBox2Value")
        //val checkBox3Value = intent.getStringExtra("checkBox3Value")

        val viewTextValueText = findViewById<TextView>(R.id.viewName)
        viewTextValueText.text = "Nama: $viewTextValue"

        val radioValueText = findViewById<TextView>(R.id.viewGender)
        radioValueText.text = "Gender: $radioValue"

        val hobiText = intent.getStringExtra("hobiText")
        checkBoxValueText.text = "Hobi: $hobiText"

        val shareButton = findViewById<Button>(R.id.btnShare)
        shareButton.setOnClickListener {
            val viewTextValue = intent.getStringExtra("viewText")
            val radioValue = intent.getStringExtra("radioValue")
            val hobiText = intent.getStringExtra("hobiText")
            val shareText = "Nama: $viewTextValue\nGender: $radioValue\nHobi: $hobiText"

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            startActivity(Intent.createChooser(sendIntent, "Share using"))
        }

        // val checkBoxValueText = findViewById<TextView>(R.id.viewHobi)
        // checkBoxValueText.text = "Hobi: $hobiText"
    }
}