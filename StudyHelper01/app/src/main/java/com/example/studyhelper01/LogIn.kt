package com.example.studyhelper01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        //parent
        val parentsButton = findViewById<Button>(R.id.parentBut)
        parentsButton.setOnClickListener {
            val intent = Intent(this, HomePageParent::class.java)
            // start your next activity
            startActivity(intent)
        }
        val button = findViewById<Button>(R.id.childButton)
        button.setOnClickListener {
            val intent = Intent(this, ChildHomePage::class.java)
            // start your next activity
            startActivity(intent)
        }

    }
}