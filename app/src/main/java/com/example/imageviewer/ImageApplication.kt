package com.example.imageviewer

import android.app.Application
import com.facebook.stetho.Stetho

class ImageApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}