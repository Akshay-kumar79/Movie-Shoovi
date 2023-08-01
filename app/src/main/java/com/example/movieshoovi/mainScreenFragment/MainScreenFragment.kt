package com.example.movieshoovi.mainScreenFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieshoovi.models.MoviesModel
import com.example.movieshoovi.databinding.FragmentMainScreenBinding
import com.example.movieshoovi.network.MoviesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainScreenFragment : Fragment(){

    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel: MainScreenViewModel by lazy { ViewModelProvider(this).get(MainScreenViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setRecyclerView()

        return binding.root
    }

    private fun setRecyclerView() {
        val popularMovieAdapter = MovieListAdapter(MovieClickListener {
            findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragment2ToDetailScreenFragment())
        })

        binding.recyclerViewPopular.adapter = popularMovieAdapter

        val trendingMovieAdapter = MovieListAdapter(MovieClickListener {
            findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragment2ToDetailScreenFragment())
        })
        binding.recyclerViewTrending.adapter = trendingMovieAdapter

        val upcomingMovieAdapter = MovieListAdapter(MovieClickListener {
            findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragment2ToDetailScreenFragment())
        })
        binding.recyclerViewUpcoming.adapter = upcomingMovieAdapter
    }
}