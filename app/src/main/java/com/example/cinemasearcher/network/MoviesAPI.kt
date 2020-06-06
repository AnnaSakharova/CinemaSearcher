package com.example.cinemasearcher.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.cinemasearcher.model.PopularMovies

interface MoviesAPI {

    @GET("movie/popular?api_key=5db4e8292aa115ea2fafa4ef4c7ac872&language=ru-RU")
    fun getMovies(): Single<PopularMovies>

    @GET("movie/{movie_id}?api_key=5db4e8292aa115ea2fafa4ef4c7ac872&language=ru-RU")
    fun getDetails(@Path("movie_id") id: Int): Single<PopularMovies>




}