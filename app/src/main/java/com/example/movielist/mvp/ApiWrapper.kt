package com.example.movielist.mvp


import com.example.movielist.model.MoviePopular

interface ApiWrapper {
    interface CallBack<in T> {
        fun onSuccess(t: T)
        fun onFailure(message: String)
    }
    fun getPopularList(callback: CallBack<MoviePopular>)
}