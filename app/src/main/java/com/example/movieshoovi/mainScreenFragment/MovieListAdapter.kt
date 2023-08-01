package com.example.movieshoovi.mainScreenFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieshoovi.models.SingleMovieModel
import com.example.movieshoovi.databinding.MovieListItemBinding

class MovieListAdapter( private val clickListener: MovieClickListener)
    : RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {

    private var movieList: List<SingleMovieModel> = ArrayList()

    fun setData(data: List<SingleMovieModel>){
        movieList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MyViewHolder private constructor(private val binding: MovieListItemBinding)
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        private lateinit var clickListener: MovieClickListener

        init {
            binding.moviePoster.setOnClickListener(this)
        }

         fun bind(movie: SingleMovieModel, clickListener: MovieClickListener) {

             binding.movie = movie
             binding.executePendingBindings()
             this.clickListener = clickListener

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieListItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

        override fun onClick(v: View?) {
            clickListener.onClick(adapterPosition)
        }

    }
}

class MovieClickListener(val clickListener: (position: Int) -> Unit){
    fun onClick(pos: Int) = clickListener(pos)
}