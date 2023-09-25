package com.example.musicapp.musicoffline.view.playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicapp.R
import com.example.musicapp.databinding.ActivityPlaylistBinding
import com.example.musicapp.databinding.AddPlaylistDialogBinding
import com.example.musicapp.musicoffline.ActivityMusicOffline
import com.example.musicapp.musicoffline.models.MusicPlaylist
import com.example.musicapp.musicoffline.models.Playlist
import com.example.musicapp.musicoffline.models.setDialogBtnBackground
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PlaylistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistBinding
    private lateinit var adapter: PlaylistViewAdapter

    companion object{
        var musicPlaylist: MusicPlaylist = MusicPlaylist()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(ActivityMusicOffline.currentTheme[ActivityMusicOffline.themeIndex])
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.playlistRV.setHasFixedSize(true)
        binding.playlistRV.setItemViewCacheSize(13)
        binding.playlistRV.layoutManager = GridLayoutManager(this, 2)
        adapter = PlaylistViewAdapter(this, playlistList = musicPlaylist.ref)
        binding.playlistRV.adapter = adapter
        binding.backBtnPLA.setOnClickListener { finish() }
        binding.addPlaylistBtn.setOnClickListener {
//            customAlertDialog()
        }

        if(musicPlaylist.ref.isNotEmpty()) binding.instructionPA.visibility = View.GONE
    }
//    private fun customAlertDialog(){
//        val customDialog = LayoutInflater.from(this).inflate(R.layout.add_playlist_dialog,binding.root,false)
//        val binder = AddPlaylistDialogBinding.bind(customDialog)
//        val builder = MaterialAlertDialogBuilder(this)
//        val dialog = builder.setView(customDialog)
//            .setTitle("Playlist Details")
//            .setPositiveButton("ADD"){ dialog, _ ->
//                val playlistName = binder.playlistName.text
//                val createdBy = binder.yourName.text
//                if(playlistName != null && createdBy != null)
//                    if(playlistName.isNotEmpty() && createdBy.isNotEmpty())
//                    {
//                        addPlaylist(playlistName.toString(), createdBy.toString())
//                    }
//                dialog.dismiss()
//            }.create()
//        dialog.show()
//        setDialogBtnBackground(this, dialog)
//
//    }
    private fun addPlaylist(name: String, createdBy: String){
        var playlistExists = false
        for(i in musicPlaylist.ref) {
            if (name == i.name){
                playlistExists = true
                break
            }
        }
        if(playlistExists) Toast.makeText(this, "Playlist Exist!!", Toast.LENGTH_SHORT).show()
        else {
            val tempPlaylist = Playlist()
            tempPlaylist.name = name
            tempPlaylist.playlist = ArrayList()
            tempPlaylist.createdBy = createdBy
            val calendar = Calendar.getInstance().time
            val sdf = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
            tempPlaylist.createdOn = sdf.format(calendar)
            musicPlaylist.ref.add(tempPlaylist)
            adapter.refreshPlaylist()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}