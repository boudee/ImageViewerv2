package com.example.imageviewer.image

interface ImageContract {

    interface  Presenter : BasePresenter{
      fun loadImages()

    }

    interface View{
        fun showProgress(isRefreshing:Boolean)
        fun updateView(photos:MutableList<PhotoViewModel>)
    }
}