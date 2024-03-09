package com.vijay.musicfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.RoundedCorner
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.vijay.musicfirebase.adapter.SongListAdapter
import com.vijay.musicfirebase.databinding.ActivityMainBinding
import com.vijay.musicfirebase.databinding.ActivitySongListBinding
import com.vijay.musicfirebase.models.CategoryModel

class SongListActivity : AppCompatActivity() {

    companion object{
        lateinit var category: CategoryModel
    }

    lateinit var binding: ActivitySongListBinding
    lateinit var adapter:SongListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textSongList.text = category.name
        Glide.with(binding.imageSongList).load(category.CoverUrl)
            .apply {
                RequestOptions().transform(RoundedCorners(32))
            }
            .into(binding.imageSongList)

        setUpSongsListRecyclerView()


    }

    fun setUpSongsListRecyclerView(){
       // songsListAdapter = SongListAdapter(category.)
        adapter = SongListAdapter(category.Songs)
        binding.recyclerSongList.layoutManager=LinearLayoutManager(this)
        binding.recyclerSongList.adapter = adapter
    }
}