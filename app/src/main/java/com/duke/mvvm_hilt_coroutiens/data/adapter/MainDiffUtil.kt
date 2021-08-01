package com.duke.mvvm_hilt_coroutiens.data.adapter

import androidx.recyclerview.widget.DiffUtil
import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModelItem

class MainDiffUtil(val oldList: List<MyPhotosModelItem>, val newList: List<MyPhotosModelItem>) :
    DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].equals(newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_, value, name) = oldList[oldItemPosition]
        val (_, value1, name1) = newList[newItemPosition]

        return name == name1 && value == value1
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}