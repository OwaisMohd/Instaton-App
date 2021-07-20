package com.i.instaton.ui.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i.instaton.data.ImgurRepository
import com.i.libimgur.models.Gallery
import com.i.libimgur.models.Image
import com.i.libimgur.models.Tag
import com.i.libimgur.models.TagsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel:ViewModel() {
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag>>()

    val tags: LiveData<List<Tag>> = _tags

    fun fetchTags() = viewModelScope.launch(Dispatchers.IO) {
        _tags.postValue(repo.getTags())
    }

}