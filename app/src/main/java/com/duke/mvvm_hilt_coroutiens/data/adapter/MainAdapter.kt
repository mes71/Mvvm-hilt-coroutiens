package com.duke.mvvm_hilt_coroutiens.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.duke.mvvm_hilt_coroutiens.R
import com.duke.mvvm_hilt_coroutiens.data.model.MyPhotosModelItem
import com.duke.mvvm_hilt_coroutiens.databinding.ItemRecyclerMainBinding
import com.squareup.picasso.Picasso
import java.util.*


class MainAdapter : RecyclerView.Adapter<MainAdapter.MainREVH>() {
    var myList = ArrayList<MyPhotosModelItem>()
        set(value) {

            val diffCallBack = MainDiffUtil(myList, value)
            val diffResult = DiffUtil.calculateDiff(diffCallBack)
            myList.clear()
            myList.addAll(value)
            diffResult.dispatchUpdatesTo(this)

        }

    inner class MainREVH(itemView: ItemRecyclerMainBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainREVH {
        val view =
            ItemRecyclerMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainREVH(view)
    }

    override fun onBindViewHolder(holder: MainREVH, position: Int) {


        holder.binding.txtItem.text = holder.binding.root.context.getString(
            R.string.title_messages,
            myList[position].id.toString(),
            myList[position].title
        )



        Picasso.get().load(myList[position].url).into(holder.binding.imgItem)


    }

    override fun getItemCount(): Int = myList.size


}