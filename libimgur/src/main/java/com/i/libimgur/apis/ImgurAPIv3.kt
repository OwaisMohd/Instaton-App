package com.i.libimgur.apis

import com.i.libimgur.models.GalleryResponse
import com.i.libimgur.models.TagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurAPIv3 {

    @GET("gallery/hot?album_previews=true") //TODO: Use Path Params
    fun getGallery(): Call<GalleryResponse>

    @GET("tags")
    fun getTags():Call<TagsResponse>

}