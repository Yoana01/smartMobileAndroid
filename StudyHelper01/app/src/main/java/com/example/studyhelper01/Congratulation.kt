package com.example.studyhelper01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Congratulation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulation)
        //achievement button
        val button = findViewById<ImageView>(R.id.achievement)
        button.setOnClickListener {
            val intent = Intent(this, Achievement::class.java)
            // start your next activity
            startActivity(intent)
        }
        //home button
        val homeButton = findViewById<ImageView>(R.id.home)
        homeButton.setOnClickListener {
            val intent = Intent(this, ChildHomePage::class.java)
            // start your next activity
            startActivity(intent)
        }
        //profile button
        val profileButton = findViewById<ImageView>(R.id.profile)
        profileButton.setOnClickListener {
            val intent = Intent(this, ChildProfile::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}