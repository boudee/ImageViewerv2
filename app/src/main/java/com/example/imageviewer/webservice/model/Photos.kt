package com.example.imageviewer.webservice.model

 data class Photos( val page: Int, val pages:Int, val perPage:Int , val total:Int, val photo:List<Photo>) {
}