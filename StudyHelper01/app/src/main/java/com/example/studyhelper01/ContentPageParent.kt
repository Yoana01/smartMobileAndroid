package com.example.studyhelper01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ContentPageParent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_page_parent)
        //progress button
        val button = findViewById<ImageView>(R.id.progress)
        button.setOnClickListener {
            val intent = Intent(this, Progress::class.java)
            // start your next activity
            startActivity(intent)
        }
        //home button
        val homeButton = findViewById<ImageView>(R.id.content)
        homeButton.setOnClickListener {
            val intent = Intent(this, ContentPageParent::class.java)
            // start your next activity
            startActivity(intent)
        }
        //profile button
        val profileButton = findViewById<ImageView>(R.id.profile)
        profileButton.setOnClickListener {
            val intent = Intent(this, HomePageParent::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

}