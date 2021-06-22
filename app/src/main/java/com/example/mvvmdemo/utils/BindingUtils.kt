package com.example.mvvmdemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.utils.extension.loadImage

object BindingUtils {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        if (url.isNullOrEmpty()) {
            this.loadImage(R.drawable.ic_launcher_foreground)
        } else {
            this.loadImage(url)
        }
    }

    @JvmStatic
    @BindingAdapter("app:setAdapter")
    fun RecyclerView.setAdapter(adapter: RecyclerView.Adapter<*>) {
        this.adapter = adapter
    }
}
