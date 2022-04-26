package com.example.studyhelper01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")


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

        //close button
        val closeButton = findViewById<ImageView>(R.id.close)
        closeButton.setOnClickListener {
            val intent = Intent(this, MathTest::class.java)
            // start your next activity
         startActivity(intent)
//            myRef.setValue("Hello, World!");
        }
    }
}