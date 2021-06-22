package com.example.mvvmdemo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sport(
    @SerializedName("idSport")
    val id: Int?,
    @SerializedName("strSport")
    val name: String?,
    @SerializedName("strSportThumb")
    val thumbnail: String?,
    @SerializedName("strSportDescription")
    val description: String?
) : Parcelable
