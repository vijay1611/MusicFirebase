package com.vijay.musicfirebase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.vijay.musicfirebase.SongListActivity
import com.vijay.musicfirebase.databinding.ActivitySongListBinding
import com.vijay.musicfirebase.databinding.SongListRecyclerViewBinding
import com.vijay.musicfirebase.models.SongsModel

class SongListAdapter(private  val songIdList : List<String>) : RecyclerView.Adapter<SongListAdapter.SongListViewHolder>() {



    class SongListViewHolder(private val binding: SongListRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(songId : String){
            binding.songName.text = songId

            FirebaseFirestore.getInstance().collection("Songs")
                .document(songId).get()
                .addOnSuccessListener {
                    val song = it.toObject(SongsModel::class.java)
                    song?.apply {
                        binding.songName.text = title
                        binding.songSubName.text = subTitle
                        Glide.with(binding.songImage).load(coverUrl)
                            .apply {
                                RequestOptions().transform(RoundedCorners(32))
                            }
                            .into(binding.songImage)
                    }
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongListViewHolder {
        val binding = SongListRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SongListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return songIdList.size
    }

    override fun onBindViewHolder(holder: SongListViewHolder, position: Int) {
        holder.bindData(songIdList[position])
    }
}