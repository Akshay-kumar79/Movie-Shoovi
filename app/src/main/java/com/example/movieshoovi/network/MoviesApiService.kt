package com.example.movieshoovi.network

import com.example.movieshoovi.models.MoviesModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY = "42c45bbf2213e62229c83be2ca898abf"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MoviesApiService{

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") key: String = API_KEY
    ): Call<MoviesModel>

    @GET("trending/movie/day")
    fun getTrendingMovies(
        @Query("api_key") key: String = API_KEY
    ): Call<MoviesModel>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") key : String = API_KEY
    ) : Call<MoviesModel>
}

object MoviesApi{
    val retrofitService: MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}