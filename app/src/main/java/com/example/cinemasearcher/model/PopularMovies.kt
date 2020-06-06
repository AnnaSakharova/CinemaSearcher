package com.example.cinemasearcher.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PopularMovies(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val total_results: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("results")
    val results: List<MovieModel> = emptyList()

)


data class MovieModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("original_language")
    val original_language: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("poster_path")
    val poster_path: String
)
//) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readString()
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(title)
//        parcel.writeString(original_language)
//        parcel.writeInt(id)
//        parcel.writeString(release_date)
//        parcel.writeString(poster_path)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<MovieModel> {
//        override fun createFromParcel(parcel: Parcel): MovieModel {
//            return MovieModel(parcel)
//        }
//
//        override fun newArray(size: Int): Array<MovieModel?> {
//            return arrayOfNulls(size)
//        }
//    }
//}

data class Movie(

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("budget")
    val budget: Int?,

    @SerializedName("genres")
    val genres: List<Genre?>?,

    @SerializedName("videos")
    var videos: List<Video>? = ArrayList(),

    @SerializedName("homepage")
    val homepage: String?,

    @SerializedName("imdb_id")
    val imdbId: String?,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("popularity")
    val popularity: Double?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("revenue")
    val revenue: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    @SerializedName("vote_count")
    val voteCount: Int?
) : Parcelable


data class Genre(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?
)




