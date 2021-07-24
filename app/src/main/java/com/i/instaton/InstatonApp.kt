package com.i.instaton

import android.app.Application
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

class InstatonApp : Application(){

    override fun onCreate() {
        super.onCreate()
        Coil.setImageLoader(ImageLoader.Builder(this@InstatonApp)
                .componentRegistry {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder(this@InstatonApp))
                    } else {
                        add(GifDecoder())
                    }
                }
                .build())
    }
}