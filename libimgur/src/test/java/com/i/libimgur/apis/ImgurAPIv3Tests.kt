package com.i.libimgur.apis

import com.i.libimgur.ImgurClient
import com.i.libimgur.params.Section
import junit.framework.Assert.assertNotNull
import org.junit.Test

class ImgurAPIv3Tests {

    val api = ImgurClient.api

    @Test
    fun `get tags working`(){

        val response = api.getTags().execute()
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries hot working`(){
        val response = api.getGallery(Section.HOT).execute()
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries top working`(){
        val response = api.getGallery(Section.TOP).execute()
        assertNotNull(response.body())
    }
}