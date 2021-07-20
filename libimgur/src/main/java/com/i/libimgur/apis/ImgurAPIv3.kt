package com.i.libimgur.apis

import com.i.libimgur.models.GalleryResponse
import com.i.libimgur.models.TagsResponse
import com.i.libimgur.params.Section
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {

    @GET("gallery/{section}")     //TODO: Use Path Params
    fun getGallery(
        @Path("section") section: Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Call<GalleryResponse>

    @GET("tags")
    fun getTags():Call<TagsResponse>

}