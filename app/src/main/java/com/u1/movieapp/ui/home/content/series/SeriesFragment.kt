package com.u1.movieapp.ui.home.content.series

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.u1.movieapp.databinding.FragmentSeriesBinding
import com.u1.movieapp.ui.detail.DetailActivity
import com.u1.movieapp.ui.detail.DetailViewModel.Companion.SERIES_TYPE
import com.u1.movieapp.utils.ViewModelFactory

class SeriesFragment : Fragment() {

    private lateinit var seriesViewModelFactory: ViewModelFactory

    private lateinit var seriesViewModel: SeriesViewModel

    private lateinit var fragmentSeriesBinding: FragmentSeriesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSeriesBinding = FragmentSeriesBinding.inflate(layoutInflater, container, false)
        return fragmentSeriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            seriesViewModelFactory = ViewModelFactory.getInstance(requireActivity())
            seriesViewModel = ViewModelProvider(this, seriesViewModelFactory)[SeriesViewModel::class.java]
            val adapterPoster = SeriesAdapter()
            val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 2

            seriesViewModel.getSeriesPopular().observe(viewLifecycleOwner, { series ->
                adapterPoster.apply {
                    setData(series)
                    setOnItemClickCallback(object: SeriesAdapter.OnItemClickCallback{
                        override fun onItemClicked(id: String) {
                            val intent = Intent(activity, DetailActivity::class.java)
                            intent.putExtra(DetailActivity.EXTRA_DATA, id)
                            intent.putExtra(DetailActivity.EXTRA_TYPE, SERIES_TYPE)
                            startActivity(intent)
                        }
                    })
                    notifyDataSetChanged()
                }
            })

            with(fragmentSeriesBinding) {
                rvPosterSeries.apply {
                    layoutManager = GridLayoutManager(context, spanCount)
                    setHasFixedSize(true)
                    adapter = adapterPoster
                }
            }
        }
    }
}