package com.u1.movieapp.ui.home.content.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.u1.movieapp.R
import com.u1.movieapp.data.model.MoviesModel
import com.u1.movieapp.databinding.ItemPosterOnlyBinding
import com.u1.movieapp.utils.ConstantVal.IMG_URL

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.DataViewHolder>() {

    private var listData = ArrayList<MoviesModel>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(data: List<MoviesModel>?) {
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemBinding = ItemPosterOnlyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size


    inner class DataViewHolder(private val binding: ItemPosterOnlyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MoviesModel) {
            with(binding) {
                titleFilm.text = data.title
                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(data.id.toString())
                }
                Glide.with(itemView.context)
                    .load(IMG_URL + data.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_broken_image))
                    .into(imgPoster)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}