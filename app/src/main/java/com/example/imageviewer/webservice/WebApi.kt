package com.example.imageviewer.webservice

import com.example.imageviewer.webservice.model.PhotoResponse
import com.example.imageviewer.webservice.model.Photos
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebApi {
 @GET("rest")
 suspend fun
         getImages(@Query("method") method:String,@Query("api_key") key: String, @Query("gallery_id") galleryId:String,@Query("format")format:String = "json",@Query("nojsoncallback") callback:String = "1"):Response<PhotoResponse>


}