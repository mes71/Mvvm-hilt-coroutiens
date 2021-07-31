package com.duke.mvvm_hilt_coroutiens.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.duke.mvvm_hilt_coroutiens.R
import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModelItem
import com.duke.mvvm_hilt_coroutiens.utils.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainHelper {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewmodel.mainHelper = this

        viewmodel.getAll()
    }

    override fun onSuccess(body: List<MyPhotosModelItem>) {
        Log.i(TAG, "onSuccess: ${body.size}")
    }
}