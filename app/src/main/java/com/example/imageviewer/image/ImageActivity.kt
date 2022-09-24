package com.example.imageviewer.image

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imageviewer.databinding.ActivityMainBinding

class ImageActivity : AppCompatActivity() ,ImageContract.View {
     private var imagePresenter :ImageContract.Presenter? = null
     private var binding : ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        imagePresenter = ImagePresenter(this)
        imagePresenter?.start()
        binding?.imageRecycler?.layoutManager = LinearLayoutManager(this)
        binding?.imageRecycler?.adapter = ImageAdapter(this)
        imagePresenter?.loadImages()
        binding?.swipeToRefresh?.setOnRefreshListener {
            imagePresenter?.loadImages()
        }

    }

    override fun showProgress(isRefreshing: Boolean) {
        binding?.swipeToRefresh?.isRefreshing = isRefreshing
    }

    override fun updateView(photos: MutableList<PhotoViewModel>) {

        (binding?.imageRecycler?.adapter as ImageAdapter).imageList = photos
        binding?.imageRecycler?.adapter?.notifyDataSetChanged()
     }



    override fun onDestroy() {
        imagePresenter?.stop()
        super.onDestroy()
    }

}