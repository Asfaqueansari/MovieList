package com.example.movielist.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class MoviePopular(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: List<Result?>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Result(
        @SerializedName("adult")
        var adult: Boolean? = null,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("genre_ids")
        var genreIds: List<Int?>? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("popularity")
        var popularity: Double? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @SerializedName("release_date")
        var releaseDate: String? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("video")
        var video: Boolean? = null,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Int? = null
    ) : Parcelable
}