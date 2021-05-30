package com.u1.movieapp.ui.home.content.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.u1.movieapp.data.model.MoviesData
import com.u1.movieapp.databinding.ItemPosterDescBinding
import com.u1.movieapp.databinding.ItemPosterOnlyBinding

class MoviesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listMovies = ArrayList<MoviesData>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MoviesData)
    }

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    private inner class MovieViewHolderPosterOnly(val binding: ItemPosterOnlyBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MoviesData){
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

    private inner class MovieViewHolderPosterDesc(val binding: ItemPosterDescBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MoviesData){
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
                dateFilm.text = data.releaseDate
                descFilm.text = data.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
            return MovieViewHolderPosterOnly(
                    ItemPosterOnlyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
        return MovieViewHolderPosterDesc(
                ItemPosterDescBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (listMovies[position].viewType == VIEW_TYPE_ONE) {
            (holder as MovieViewHolderPosterOnly).bind(listMovies[position])
        } else {
            (holder as MovieViewHolderPosterDesc).bind(listMovies[position])
        }
    }

    override fun getItemCount(): Int = listMovies.size

}