package com.example.cinemasearcher.network

import com.google.gson.annotations.SerializedName

data class PopularMovies(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val total_results: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("results")
    val results: List<MovieModel> = emptyList()
)


    data class MovieModel(
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



