package com.example.musicapp.musicoffline.view.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicapp.R
import com.example.musicapp.databinding.ActivityFavouriteBinding
import com.example.musicapp.musicoffline.models.Music

class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavouriteBinding
    private lateinit var adapter: FavouriteAdapter

    companion object{
        var favouriteSongs: ArrayList<Music> = ArrayList()
        var favouritesChanged: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
    }
}