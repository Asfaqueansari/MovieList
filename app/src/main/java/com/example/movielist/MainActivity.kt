package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.adapter.MoviePopularListAdapter
import com.example.movielist.model.MoviePopular
import com.example.movielist.mvp.Contract
import com.example.movielist.presenter.MovieActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.MovieActivityView {

    private lateinit var moviePresenter: Contract.MovieActivityPresenter
    private var movieList = mutableListOf<MoviePopular.Result?>()
    private lateinit var movieAdapter: MoviePopularListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPresenter(MovieActivityPresenter(this))
        init()
        moviePresenter.getMoviePopular()
        listenSearches()
    }
    private fun listenSearches() {
        search_movie!!.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                search(s.toString())
            }
        })
    }
    private fun init() {
        movie_recycler_view!!.layoutManager = LinearLayoutManager(this)
    }

    fun search(query: String): Boolean {
        movieList.let { movies ->
            if (query.isNotEmpty()) {
                movieAdapter.moviePopularList = movies.filter {
                    it!!.originalTitle!!.contains(query, true)
                }
                movieAdapter.notifyDataSetChanged()
            } else {
                movieAdapter.moviePopularList = (movies)
                movieAdapter.notifyDataSetChanged()
                return true
            }
        }
        return false
    }
    override fun onSuccessGettingMoviePopular(popularMovieList: MoviePopular) {
        movieList = popularMovieList.results!!.toMutableList()
        movieAdapter = MoviePopularListAdapter(movieList, this)
        movie_recycler_view!!.adapter = movieAdapter
    }
    override fun onErrorGettingMoviePopular(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    override fun setPresenter(Presenter: Contract.MovieActivityPresenter) {
        this.moviePresenter = Presenter
    }

}
