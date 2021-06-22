package com.example.mvvmdemo.screen.listsport.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvmdemo.data.model.Sport

class SportDiffUtil : DiffUtil.ItemCallback<Sport>() {

    override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Sport, newItem: Sport): Boolean =
        oldItem == newItem
}
