package com.u1.movieapp.ui.home.content.series

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.databinding.FragmentSeriesBinding
import com.u1.movieapp.ui.detail.DetailActivity
import com.u1.movieapp.ui.home.adapter.DescAdapter
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
            val dataSeriesPlaying = seriesViewModel.getSeriesPlaying()
            val dataSeriesPopular = seriesViewModel.getSeriesPopular()
            val adapterPoster = PosterAdapter()
            val adapterDesc = DescAdapter()

            adapterDesc.setOnItemClickCallback(object: DescAdapter.OnItemClickCallback{
                override fun onItemClicked(data: DummyData) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            })

            adapterPoster.setOnItemClickCallback(object: PosterAdapter.OnItemClickCallback{
                override fun onItemClicked(data: DummyData) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            })

            adapterPoster.setData(dataSeriesPlaying)
            adapterDesc.setData(dataSeriesPopular)

            with(fragmentSeriesBinding) {
                rvPosterSeries.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    setHasFixedSize(true)
                    adapter = adapterPoster
                }

                rvPosterDescSeries.apply {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = adapterDesc
                }
            }
        }
    }
}