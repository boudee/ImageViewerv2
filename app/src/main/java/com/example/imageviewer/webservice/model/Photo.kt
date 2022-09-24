package com.example.imageviewer.webservice.model

import com.google.gson.annotations.SerializedName

data class Photo( val id:String, val owner:String, val secret:String, val server:String, val farm:Int, val title:String, val isPublic:Boolean,
                 val isFriend:Boolean, val isFamily:Boolean, val isPrimary:Boolean, val hasComment:Boolean) {


}