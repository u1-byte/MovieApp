package com.u1.movieapp.ui.home.content.series

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.u1.movieapp.data.local.model.DummyData
import com.u1.movieapp.databinding.FragmentSeriesBinding
import com.u1.movieapp.ui.detail.DetailActivity
import com.u1.movieapp.ui.home.adapter.PosterAdapter

class SeriesFragment : Fragment() {

    private val seriesViewModel: SeriesViewModel by viewModels()

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
            val dataSeriesPopular = seriesViewModel.getSeriesPopular()
            val adapterPoster = PosterAdapter()
            val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 2

            adapterPoster.setOnItemClickCallback(object: PosterAdapter.OnItemClickCallback{
                override fun onItemClicked(data: DummyData) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            })

            adapterPoster.setData(dataSeriesPopular)

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