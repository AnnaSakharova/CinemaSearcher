package com.example.cinemasearcher.network

import retrofit2.Call
import retrofit2.http.GET


interface MoviesAPI {

    @GET("movie/popular?api_key=5db4e8292aa115ea2fafa4ef4c7ac872&language=ru-RU")
    fun getMovies(): Call<ArrayList<Movies>>
}