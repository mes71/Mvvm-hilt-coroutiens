package com.duke.mvvm_hilt_coroutiens.ui

import androidx.lifecycle.ViewModel
import com.duke.mvvm_hilt_coroutiens.data.repository.MyRepository
import com.duke.mvvm_hilt_coroutiens.utils.Coroutines
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {

    lateinit var mainHelper: MainHelper

    fun getAll() {
        Coroutines.main {
            val response = repository.getAllPhoto()
            if (response.isSuccessful && response.body()?.size!! > 0) {
                mainHelper.onSuccess(response.body()!!)
            }
        }
    }
}