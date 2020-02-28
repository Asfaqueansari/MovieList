package com.example.movielist.Network

import com.example.movielist.model.MoviePopular
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("movie/popular?api_key=ad57d5ad66f7cdc50e56f9c65ec3ea23&language=en-US&page=1")
    fun getPopularList(): Call<MoviePopular>
}