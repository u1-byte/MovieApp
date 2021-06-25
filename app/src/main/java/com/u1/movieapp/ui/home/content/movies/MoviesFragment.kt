package com.u1.movieapp.ui.home.content.movies

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.u1.movieapp.databinding.FragmentMoviesBinding
import com.u1.movieapp.ui.detail.DetailActivity
import com.u1.movieapp.ui.detail.DetailViewModel.Companion.MOVIES_TYPE
import com.u1.movieapp.utils.ViewModelFactory

class MoviesFragment : Fragment() {

    private lateinit var moviesViewModelFactory: ViewModelFactory

    private lateinit var moviesViewModel: MoviesViewModel

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
            moviesViewModelFactory = ViewModelFactory.getInstance(requireActivity())
            moviesViewModel = ViewModelProvider(this, moviesViewModelFactory)[MoviesViewModel::class.java]
            val adapterPoster = MoviesAdapter()
            val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 2

            moviesViewModel.getMoviesPopular().observe(viewLifecycleOwner, { movies ->
                adapterPoster.apply {
                    setData(movies)
                    setOnItemClickCallback(object: MoviesAdapter.OnItemClickCallback{
                        override fun onItemClicked(id: String) {
                            val intent = Intent(activity, DetailActivity::class.java)
                            intent.putExtra(DetailActivity.EXTRA_DATA, id)
                            intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIES_TYPE)
                            startActivity(intent)
                        }
                    })
                    notifyDataSetChanged()
                }
            })

            with(fragmentMoviesBinding) {
                rvPosterMovies.apply {
                    layoutManager = GridLayoutManager(context, spanCount)
                    setHasFixedSize(true)
                    adapter = adapterPoster
                }
            }
        }
    }
}