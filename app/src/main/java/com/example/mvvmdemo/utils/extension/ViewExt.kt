package com.example.mvvmdemo.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(strUrl: String) {
    Glide.with(this.context.applicationContext)
        .load(strUrl)
        .into(this)
}
