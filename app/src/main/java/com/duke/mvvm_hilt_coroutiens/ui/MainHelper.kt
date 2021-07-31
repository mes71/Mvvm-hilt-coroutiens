package com.duke.mvvm_hilt_coroutiens.ui

import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModelItem

interface MainHelper {

    fun onSuccess(body: List<MyPhotosModelItem>)
}