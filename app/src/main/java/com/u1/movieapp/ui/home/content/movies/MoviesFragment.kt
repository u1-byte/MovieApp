package com.u1.movieapp.ui.home.content.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.u1.movieapp.databinding.FragmentMoviesBinding
import com.u1.movieapp.ui.home.adapter.DescAdapter
import com.u1.movieapp.ui.home.adapter.PosterAdapter

class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by viewModels()

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val dataMoviesPlaying = moviesViewModel.getMoviesPlaying()
            val dataMoviesPopular = moviesViewModel.getMoviesPopular()
            val adapterPoster = PosterAdapter()
            val adapterDesc = DescAdapter()

            adapterPoster.setData(dataMoviesPlaying)
            adapterDesc.setData(dataMoviesPopular)

            with(fragmentMoviesBinding) {
                rvPoster.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    setHasFixedSize(true)
                    adapter = adapterPoster
                }

                rvPosterDesc.apply {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = adapterDesc
                }
            }
        }
    }
}