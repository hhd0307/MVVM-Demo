package com.example.mvvmdemo.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(strUrl: String) {
    Glide.with(this)
        .load(strUrl)
        .into(this)
}

fun ImageView.loadImage(strUrl: Int) {
    Glide.with(this)
        .load(strUrl)
        .into(this)
}
