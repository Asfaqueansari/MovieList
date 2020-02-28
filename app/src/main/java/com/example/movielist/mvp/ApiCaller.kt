package com.example.movielist.mvp

import com.example.movielist.Network.ApiInterface
import com.example.movielist.model.MoviePopular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCaller :ApiWrapper{
    companion object ApiCaller{
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
    override fun getPopularList(callback: ApiWrapper.CallBack<MoviePopular>) {
        retrofitBuilder().getPopularList().enqueue(object :Callback<MoviePopular>{
            override fun onFailure(call: Call<MoviePopular>, t: Throwable) {
                t.message.let {
                    callback.onFailure(t.message.toString())
                }
            }
            override fun onResponse(call: Call<MoviePopular>, response: Response<MoviePopular>) {
                if(response.isSuccessful){
                    response.body().let {
                        callback.onSuccess(it!!)
                    }
                }
            }
        })
    }
    private fun retrofitBuilder() : ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
}