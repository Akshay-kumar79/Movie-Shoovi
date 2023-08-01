package com.example.movieshoovi.models

import com.squareup.moshi.Json

data class SingleMovieModel(val title: String,
                            @Json(name = "poster_path") val imageUrl: String,
                            @Json(name = "release_date") val releaseDate: String)

