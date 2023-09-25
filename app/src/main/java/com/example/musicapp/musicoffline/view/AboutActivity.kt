package com.example.musicapp.musicoffline.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicapp.R
import com.example.musicapp.databinding.ActivityAboutBinding
import com.example.musicapp.musicoffline.ActivityMusicOffline

class AboutActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(ActivityMusicOffline.currentThemeNav[ActivityMusicOffline.themeIndex])
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "About"
        binding.aboutText.text = aboutText()
    }
    private fun aboutText(): String{
        return "Developed By: Harsh H. Rajpurohit" +
                "\n\nIf you want to provide feedback, I will love to hear that."
    }
}