package com.i.instaton.data

import com.i.libimgur.ImgurClient
import com.i.libimgur.models.Image
import com.i.libimgur.params.Section

class ImgurRepository {
    val api = ImgurClient.api

    suspend fun getHotFeed(): List<Image>? {//TODO : return a proper error object if null
        val response = api.getGallery(Section.HOT)
        return response.body()?.data as List<Image>?
    }
    suspend fun getTopFeed(): List<Image>?{
        val response = api.getGallery(Section.TOP)
        return response.body()?.data as List<Image>?
    }

}