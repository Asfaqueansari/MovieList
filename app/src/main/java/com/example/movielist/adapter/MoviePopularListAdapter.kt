package com.example.movielist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.R
import com.example.movielist.model.MoviePopular
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_single_list.view.*

class MoviePopularListAdapter( var moviePopularList:List<MoviePopular.Result?>, var context: Context):
    RecyclerView.Adapter<MoviePopularListAdapter.ViewHolder>() {
    companion object{
        const val baseImageUrl : String = "https://image.tmdb.org/t/p/w185"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_single_list,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return moviePopularList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moviePopularList[position]!!,position)
    }
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
        fun bind(result: MoviePopular.Result, position: Int) {
            view.movie_title.text = result.originalTitle
            view.movie_year.text = result.releaseDate
            view.movie_rating.text = result.voteAverage.toString()
            Picasso.get().load(baseImageUrl.plus(result.posterPath)).into(view.movie_poster)
        }
    }
}