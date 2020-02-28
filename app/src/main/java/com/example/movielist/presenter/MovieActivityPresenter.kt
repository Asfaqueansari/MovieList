package com.example.movielist.presenter

import com.example.movielist.model.MoviePopular
import com.example.movielist.mvp.ApiCaller
import com.example.movielist.mvp.ApiWrapper
import com.example.movielist.mvp.Contract

class MovieActivityPresenter(private val view : Contract.MovieActivityView): Contract.MovieActivityPresenter {

    private val apiCaller = ApiCaller()
    override fun getMoviePopular() {
        apiCaller.getPopularList(object:ApiWrapper.CallBack<MoviePopular>{
            override fun onSuccess(t: MoviePopular) {
                view.onSuccessGettingMoviePopular(t)
            }
            override fun onFailure(message: String) {
                view.onErrorGettingMoviePopular(message)
            }
        })
    }
}