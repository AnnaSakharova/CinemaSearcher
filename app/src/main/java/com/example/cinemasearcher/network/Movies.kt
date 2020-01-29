package com.example.cinemasearcher.network

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("title")
    val title: String,

    @SerializedName("original_language")
    val original_language: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("poster_path")
    val poster_path: String
)


