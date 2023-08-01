package com.example.movieshoovi.movieDetailsfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieshoovi.models.SingleLargeMovieModel
import com.example.movieshoovi.databinding.MovieLargeListItemBinding

class LargeMovieListAdapter(private val context: Context,private val movieList: List<SingleLargeMovieModel>) : RecyclerView.Adapter<LargeMovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder private constructor(private val binding: MovieLargeListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context, movieList: SingleLargeMovieModel) {
            binding.moviePoster.setImageResource(movieList.imageUrl)
            binding.movieTitle.text = movieList.title
            binding.rating.text = movieList.rating.toString()
            binding.releaseDate.text = movieList.releaseDate
        }

        companion object{
            fun from(parent: ViewGroup) : ViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = MovieLargeListItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}