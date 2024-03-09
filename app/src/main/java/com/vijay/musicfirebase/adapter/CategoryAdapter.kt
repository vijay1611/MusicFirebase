package com.vijay.musicfirebase.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vijay.musicfirebase.SongListActivity
import com.vijay.musicfirebase.databinding.CategoryItemRecyclerRowBinding
import com.vijay.musicfirebase.models.CategoryModel

class CategoryAdapter(private val categoryList : List<CategoryModel>): RecyclerView.Adapter<CategoryAdapter.MyViewHolder> (){


    class MyViewHolder(private val binding: CategoryItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
            fun bindData(category:CategoryModel){
                binding.nameText.text = category.name
                Glide.with(binding.coverImage).load(category.CoverUrl).into(binding.coverImage)
             //   binding.coverImage

                val context = binding.root.context
                binding.root.setOnClickListener{
                    SongListActivity.category = category
                    context.startActivity(Intent(context,SongListActivity::class.java))
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}