package com.example.studyhelper01

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MathExercise01 : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_exercise01)
        val pictureButton: Button = findViewById(R.id.camerabutton)
        pictureButton.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
            }
        }

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

        //submit button
        val submitButton = findViewById<Button>(R.id.submit)
        submitButton.setOnClickListener {
            val intent = Intent(this, MathExerciseResult::class.java)
            // start your next activity
            startActivity(intent)
        }

        //undo button
        val undoButton = findViewById<Button>(R.id.undo1)
        undoButton.setOnClickListener {
            val intent = Intent(this, lessonKidCreature::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
    private fun dispatchTakePictureIntent() {

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView: ImageView = findViewById(R.id.imageView)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

}
