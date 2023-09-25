package com.example.musicapp.musicoffline.view.selection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.R
import com.example.musicapp.databinding.ActivitySelectionBinding
import com.example.musicapp.musicoffline.ActivityMusicOffline
import com.example.musicapp.musicoffline.view.MusicAdapter

class SelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionBinding
    private lateinit var adapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setTheme(ActivityMusicOffline.currentTheme[ActivityMusicOffline.themeIndex])
        setContentView(binding.root)
        binding.selectionRV.setItemViewCacheSize(30)
        binding.selectionRV.setHasFixedSize(true)
        binding.selectionRV.layoutManager = LinearLayoutManager(this)
        adapter = MusicAdapter(this, ActivityMusicOffline.MusicListMA, selectionActivity = true)
        binding.selectionRV.adapter = adapter
        binding.backBtnSA.setOnClickListener { finish() }
        //for search View
        binding.searchViewSA.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean = true
            override fun onQueryTextChange(newText: String?): Boolean {
                ActivityMusicOffline.musicListSearch = ArrayList()
                if(newText != null){
                    val userInput = newText.lowercase()
                    for (song in ActivityMusicOffline.MusicListMA)
                        if(song.title.lowercase().contains(userInput))
                            ActivityMusicOffline.musicListSearch.add(song)
                    ActivityMusicOffline.search = true
                    adapter.updateMusicList(searchList = ActivityMusicOffline.musicListSearch)
                }
                return true
            }
        })
    }

    override fun onResume() {
        super.onResume()
        //for black theme checking
        if(ActivityMusicOffline.themeIndex == 4)
        {
            binding.searchViewSA.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
        }
    }
}