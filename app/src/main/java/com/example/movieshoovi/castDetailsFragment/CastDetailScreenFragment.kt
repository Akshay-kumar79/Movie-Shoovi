package com.example.movieshoovi.castDetailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieshoovi.R

class CastDetailScreenFragment : Fragment() {

    private lateinit var viewModel: CastDetailScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cast_detail_screen, container, false)
    }

}