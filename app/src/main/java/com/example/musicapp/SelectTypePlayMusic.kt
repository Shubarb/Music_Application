package com.example.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.musicapp.databinding.ActivitySelectTypePlayMusicBinding
import com.example.musicapp.musicoffline.ActivityMusicOffline
import com.example.musicapp.musiconline.ActivityMusicOnline

class SelectTypePlayMusic : AppCompatActivity() {
    private lateinit var binding: ActivitySelectTypePlayMusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_type_play_music)
        binding.btnMusicOffline.setOnClickListener {
            val intent = Intent(this,ActivityMusicOffline::class.java)
            startActivity(intent)
        }
        binding.btnMusicOnline.setOnClickListener {
            val intent = Intent(this, ActivityMusicOnline::class.java)
            startActivity(intent)
        }
    }

}