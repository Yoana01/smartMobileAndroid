package com.example.studyhelper01

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.IOException


class lessonKidCreature : AppCompatActivity() {

    private var output: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false
    var file : File?= null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_kid_creature)

        val filePath = Environment.getExternalStorageDirectory()
            .toString() + File.separator + "recording.3gpp"
        file = File(filePath)
//        output = Environment.getExternalStorageDirectory()
//            .absolutePath + "/myaudio.m4a"


        //exercise button
        val exerciseButton = findViewById<Button>(R.id.exercise)
        exerciseButton.setOnClickListener {
            val intent = Intent(this, MathExercise::class.java)
            // start your next activity
            startActivity(intent)
        }

        //test button
        val testButton = findViewById<Button>(R.id.test)
        testButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
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
        val microphoneButton = findViewById<Button>(R.id.micButton)
        microphoneButton.setOnClickListener {
            mediaRecorder = MediaRecorder()


            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                val permissions = arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                ActivityCompat.requestPermissions(this, permissions,0)
            } else {
                startRecording()
            }
        }

        val stopRecordingButton = findViewById<Button>(R.id.stopRecording)
        stopRecordingButton.setOnClickListener {
            stopRecording()
        }



    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun resetRecorder() {
        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        mediaRecorder?.setOutputFile(file)
        try {
            mediaRecorder?.prepare()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun startRecording() {
        try {
            resetRecorder()
            mediaRecorder?.start()
            state = true
            Toast.makeText(this, "Recording started!", Toast.LENGTH_SHORT).show()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    private fun stopRecording(){
        if(state){
            mediaRecorder?.stop()
            mediaRecorder?.release()
            mediaRecorder=null
            state = false
        }else{
            Toast.makeText(this, "You are not recording right now!", Toast.LENGTH_SHORT).show()
        }
    }

}