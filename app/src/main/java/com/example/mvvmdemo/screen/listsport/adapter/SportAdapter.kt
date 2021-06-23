package com.example.mvvmdemo.screen.listsport.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.data.model.Sport
import com.example.mvvmdemo.databinding.ItemSportBinding

class SportAdapter(
    private var clickListener: (Sport) -> Unit
) : ListAdapter<Sport, SportAdapter.ViewHolder>(SportDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemSportBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_sport,
            parent,
            false
        )
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class ViewHolder(
        private val binding: ItemSportBinding,
        private val onItemClicked: (Sport) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.sportViewModel = ItemSportViewModel()
        }

        fun bind(sport: Sport) {
            binding.apply {
                sportViewModel?.sport = sport
                executePendingBindings()
                imageSport.setOnClickListener {
                    onItemClicked(sport)
                }
            }
        }
    }
}
