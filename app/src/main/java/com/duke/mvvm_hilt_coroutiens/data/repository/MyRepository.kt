package com.duke.mvvm_hilt_coroutiens.data.repository

import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModelItem
import com.duke.mvvm_hilt_coroutiens.data.net.MyApi
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(private val myApi: MyApi) {


    suspend fun getAllPhoto(): Response<ArrayList<MyPhotosModelItem>> {
        return myApi.getPhotos("photos")
    }


}

