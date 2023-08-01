package com.example.movieshoovi.models

import com.squareup.moshi.Json

data class MoviesModel(@Json(name = "results") val movies: List<SingleMovieModel>,
                       @Json(name = "total_pages") val totalPage: Int )
