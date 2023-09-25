package com.example.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class ActivityMusicOffline : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.splashImage)

        // Load the rotation animation
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)

        // Set animation listener to start the main activity when animation ends
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                // Start the main activity
                val intent = Intent(this@ActivityMusicOffline, SelectTypePlayMusic::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        // Start the animation
        imageView.startAnimation(animation)
    }
}