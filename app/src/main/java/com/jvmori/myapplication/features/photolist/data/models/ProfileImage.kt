package com.jvmori.myapplication.features.photolist.data.models


import com.google.gson.annotations.SerializedName

data class ProfileImage(
    @SerializedName("large")
    var large: String = "",
    @SerializedName("medium")
    var medium: String = "",
    @SerializedName("small")
    var small: String = ""
)