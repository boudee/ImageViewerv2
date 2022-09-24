package com.example.imageviewer.image

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageviewer.databinding.ImageItemBinding
import com.example.imageviewer.webservice.model.Photo

class ImageAdapter(val context:Context):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    var imageList : MutableList<PhotoViewModel> = ArrayList()


   inner class ImageViewHolder(val binding:ImageItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }




    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        with(holder){
            with(imageList[position]){
                val imageUrl = "https://live.staticflickr.com/${this.server}/${this.id}_${this.secret}.jpg"
                Glide.with(context).load(imageUrl).into(binding.photoImgView)
                binding.photoTitle.text = if(this.title.isNullOrEmpty()) "No Title" else this.title
            }
        }

    }




}