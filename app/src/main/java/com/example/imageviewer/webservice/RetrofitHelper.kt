package com.example.imageviewer.webservice

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun createWebService(): WebApi {
        val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor()).addInterceptor(ResponseInterceptor()).build()

        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(WebApi::class.java)
    }



        const val method="flickr.galleries.getPhotos"
        private const val baseUrl = "https://www.flickr.com/services/"
        const val galleryId = "72157721098901957"
        const val flickrKey = "f69aaed9e8687bd4546b7e09b0384d07"



}