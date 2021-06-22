package com.example.mvvmdemo.data.repository.source.remote.api.response

import com.example.mvvmdemo.data.model.Sport
import com.google.gson.annotations.SerializedName

class SportResponse {
    @SerializedName("sports")
    lateinit var sportItems: MutableList<Sport>
}
