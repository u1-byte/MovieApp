package com.u1.movieapp.ui.home.content.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.u1.movieapp.data.model.SeriesData
import com.u1.movieapp.databinding.ItemPosterDescBinding
import com.u1.movieapp.databinding.ItemPosterOnlyBinding

class SeriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listSeries = ArrayList<SeriesData>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: SeriesData)
    }

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    private inner class SeriesViewHolderPosterOnly(val binding: ItemPosterOnlyBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SeriesData){
            binding.root.setOnClickListener {
                onItemClickCallback.onItemClicked(data)
            }

            Glide.with(itemView)
                .load(data.posterImg)
                .centerCrop()
                .into(binding.imgPoster)
            binding.titleFilm.text = data.title
        }
    }

    private inner class SeriesViewHolderPosterDesc(val binding: ItemPosterDescBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SeriesData){
            binding.root.setOnClickListener {
                onItemClickCallback.onItemClicked(data)
            }

            binding.apply {
                Glide.with(itemView)
                    .load(data.posterImg)
                    .centerCrop()
                    .into(imgPoster)
                titleFilm.text = data.title
                genreFilm.text = data.genre
                dateFilm.text = data.airedDate
                descFilm.text = data.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
            return SeriesViewHolderPosterOnly(
                ItemPosterOnlyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
        return SeriesViewHolderPosterDesc(
            ItemPosterDescBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (listSeries[position].viewType == VIEW_TYPE_ONE) {
            (holder as SeriesViewHolderPosterOnly).bind(listSeries[position])
        } else {
            (holder as SeriesViewHolderPosterDesc).bind(listSeries[position])
        }
    }

    override fun getItemCount(): Int = listSeries.size
}