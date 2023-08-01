package com.example.movieshoovi.mainScreenFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieshoovi.models.MoviesModel
import com.example.movieshoovi.models.SingleMovieModel
import com.example.movieshoovi.network.MoviesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainScreenViewModel : ViewModel() {

    private val _popularMovieListData = MutableLiveData<List<SingleMovieModel>>()

    val popularMovieListData: LiveData<List<SingleMovieModel>>
        get() = _popularMovieListData

    private val _trendingMovieListData = MutableLiveData<List<SingleMovieModel>>()

    val trendingMovieListData: LiveData<List<SingleMovieModel>>
        get() = _trendingMovieListData

    private val _upcomingMovieListData = MutableLiveData<List<SingleMovieModel>>()

    val upcomingMovieListData: LiveData<List<SingleMovieModel>>
        get() = _upcomingMovieListData

    init {
        fetchPopularMovies()
        fetchTrendingMovies()
        fetchUpcomingMovies()
    }

    private fun fetchPopularMovies() {
        MoviesApi.retrofitService.getPopularMovies().enqueue(object : Callback<MoviesModel> {

            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
                if (response.code() != 200)
                    return

                _popularMovieListData.value = response.body()!!.movies
            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {

            }

        })
    }

    private fun fetchTrendingMovies(){
        MoviesApi.retrofitService.getTrendingMovies().enqueue(object : Callback<MoviesModel> {
            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
                if(response.code() != 200)
                    return

                _trendingMovieListData.value = response.body()!!.movies

            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun fetchUpcomingMovies(){
        MoviesApi.retrofitService.getUpcomingMovies().enqueue(object : Callback<MoviesModel> {
            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
                if(response.code() != 200)
                    return

                _upcomingMovieListData.value = response.body()!!.movies
            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}