package com.duke.mvvm_hilt_coroutiens.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.duke.mvvm_hilt_coroutiens.data.adapter.MainAdapter
import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModelItem
import com.duke.mvvm_hilt_coroutiens.databinding.ActivityMainBinding
import com.duke.mvvm_hilt_coroutiens.utils.TAG
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainHelper {

    private lateinit var binder: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binder.root)

        val viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewmodel.mainHelper = this
        viewmodel.getAll()

        adapter = MainAdapter()
        binder.mainRecycler.adapter = adapter
    }

    override fun onSuccess(body: ArrayList<MyPhotosModelItem>) {
        Log.i(TAG, "onSuccess: ${body.size}")
        adapter.myList = body
    }
}