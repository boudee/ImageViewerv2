package com.example.imageviewer.image

import com.example.imageviewer.webservice.RetrofitHelper
import com.example.imageviewer.webservice.model.PhotoResponse
import com.example.imageviewer.webservice.model.Photos
import kotlinx.coroutines.*
import retrofit2.Retrofit

class ImagePresenter(val view: ImageContract.View) :ImageContract.Presenter{

    override fun loadImages() {
     CoroutineScope(Dispatchers.IO).launch {
            val retrofit = RetrofitHelper.createWebService()
            val photoResponse= retrofit.getImages(RetrofitHelper.method,RetrofitHelper.flickrKey,RetrofitHelper.galleryId)
                convertToView(photoResponse.body())
        }
    }


    private suspend fun convertToView(photoResponse: PhotoResponse?){
        val photoViewModelList :MutableList<PhotoViewModel> = ArrayList(0)
        for(photo in photoResponse?.photos?.photo.orEmpty()){
         val photoViewModel = PhotoViewModel().apply {
             id = photo.id
             title = photo.title
             server = photo.server
             secret = photo.secret
         }
         photoViewModelList.add(photoViewModel)
     }
        withContext(Dispatchers.Main){
            view.showProgress(false)
            view.updateView(photoViewModelList)
        }
    }
    override fun start() {
        loadImages()
    }

    override fun stop() {
        //Add cleanup when needed
    }
}