package com.example.musicapp.musicoffline.view.playnext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicapp.R
import com.example.musicapp.databinding.ActivityPlayNextBinding
import com.example.musicapp.musicoffline.ActivityMusicOffline
import com.example.musicapp.musicoffline.models.Music
import com.example.musicapp.musicoffline.view.favorite.FavouriteAdapter

class PlayNext : AppCompatActivity() {
    companion object{
        var playNextList: ArrayList<Music> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(ActivityMusicOffline.currentTheme[ActivityMusicOffline.themeIndex])
        val binding = ActivityPlayNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playNextRV.setHasFixedSize(true)
        binding.playNextRV.setItemViewCacheSize(13)
        binding.playNextRV.layoutManager = GridLayoutManager(this, 4)
        binding.playNextRV.adapter = FavouriteAdapter(this, playNextList, playNext = true)

        if(playNextList.isNotEmpty())
            binding.instructionPN.visibility = View.GONE

        binding.backBtnPN.setOnClickListener {
            finish()
        }
    }
}