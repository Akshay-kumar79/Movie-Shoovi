package com.example.movieshoovi.movieDetailsfragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.movieshoovi.MainActivity
import com.example.movieshoovi.models.SingleCastModel
import com.example.movieshoovi.models.SingleLargeMovieModel
import com.example.movieshoovi.R

import com.example.movieshoovi.databinding.FragmentDetailScreenBinding


class DetailScreenFragment : Fragment() {

    lateinit var binding: FragmentDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)

        SetUpToolBar()

        SetUpCastListView()

        SetUpRecommendedMovieList()

        return binding.root
    }

    private fun SetUpRecommendedMovieList() {

        val movieList: ArrayList<SingleLargeMovieModel> = ArrayList()

        movieList.add(SingleLargeMovieModel("Coda", R.drawable.img, "22 jan,2001", 7.1))
        movieList.add(SingleLargeMovieModel("The Lion King", R.drawable.img_1, "01 jun,2001", 5.1))
        movieList.add(SingleLargeMovieModel("Suit", R.drawable.img_2, "31 aug,2005", 7.5))
        movieList.add(SingleLargeMovieModel("Resort To Love", R.drawable.img_3, "15 sep,2020", 9.8))
        movieList.add(SingleLargeMovieModel("Coda", R.drawable.img, "22 jan,2001", 7.1))
        movieList.add(SingleLargeMovieModel("The Lion King", R.drawable.img_1, "01 jun,2001", 5.1))
        movieList.add(SingleLargeMovieModel("Suit", R.drawable.img_2, "31 aug,2005", 7.5))
        movieList.add(SingleLargeMovieModel("Resort To Love", R.drawable.img_3, "15 sep,2020", 9.8))
        movieList.add(SingleLargeMovieModel("Coda", R.drawable.img, "22 jan,2001", 7.1))
        movieList.add(SingleLargeMovieModel("The Lion King", R.drawable.img_1, "01 jun,2001", 5.1))
        movieList.add(SingleLargeMovieModel("Suit", R.drawable.img_2, "31 aug,2005", 7.5))
        movieList.add(SingleLargeMovieModel("Resort To Love", R.drawable.img_3, "15 sep,2020", 9.8))

        val adapter = LargeMovieListAdapter(requireContext(), movieList)

        binding.recommendedRecyclerView.adapter = adapter
    }

    private fun SetUpCastListView() {
        val castList: ArrayList<SingleCastModel> = ArrayList()

        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))
        castList.add(SingleCastModel(R.drawable.cast, "Jason Statham", "Deckard Shaw"))

        val adapter = CastListAdapter(requireContext(), castList)

        binding.castRecyclerView.adapter = adapter
    }

    private fun SetUpToolBar() {
        binding.toolBar.setupWithNavController(
            findNavController(),
            AppBarConfiguration(findNavController().graph)
        )
        (activity as MainActivity).setSupportActionBar(binding.toolBar)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.detail_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

