package com.example.mvvmdemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.utils.extension.loadImage

object BindingUtils {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        url?.let {
            this.loadImage(it)
        }
    }

    @JvmStatic
    @BindingAdapter("app:setAdapter")
    fun RecyclerView.setAdapter(adapter: RecyclerView.Adapter<*>) {
        this.adapter = adapter
    }
}
