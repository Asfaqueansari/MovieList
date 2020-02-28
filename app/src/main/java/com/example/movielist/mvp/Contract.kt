package com.example.movielist.mvp

import com.example.movielist.model.MoviePopular

class Contract {

    interface MovieActivityView:BaseView<MovieActivityPresenter> {
        fun onSuccessGettingMoviePopular(popularMovieList:MoviePopular)
        fun onErrorGettingMoviePopular(message:String)
    }
    interface MovieActivityPresenter{
        fun  getMoviePopular()
    }
}