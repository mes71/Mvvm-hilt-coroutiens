package com.duke.mvvm_hilt_coroutiens.data.net


import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModel
import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModelItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MyApi {

    @GET("/{id}")
   suspend fun getPhotos(@Path("id") path: String): Response<ArrayList<MyPhotosModelItem>>
}