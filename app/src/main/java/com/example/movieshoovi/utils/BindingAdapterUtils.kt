package com.example.movieshoovi.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieshoovi.mainScreenFragment.MovieClickListener
import com.example.movieshoovi.mainScreenFragment.MovieListAdapter
import com.example.movieshoovi.models.SingleMovieModel

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView,movie: SingleMovieModel) {
    Glide.with(imageView.context).load("https://image.tmdb.org/t/p/w500${movie.imageUrl}").into(imageView)
}

@BindingAdapter("listData")
fun listData(recyclerView: RecyclerView, data: List<SingleMovieModel>?){
    val adapter = recyclerView.adapter as MovieListAdapter
    if (data != null) {
        adapter.setData(data)
    }
}