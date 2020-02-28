package com.example.movielist.mvp

interface BaseView<in T> {
    fun setPresenter(Presenter:T)
}