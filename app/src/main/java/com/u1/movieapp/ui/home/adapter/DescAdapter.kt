package com.u1.movieapp.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.u1.movieapp.R
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.databinding.ItemPosterDescBinding
import com.u1.movieapp.ui.detail.DetailActivity

class DescAdapter : RecyclerView.Adapter<DescAdapter.DataViewHolder>() {

    private var listData = ArrayList<DummyData>()

    fun setData(data: List<DummyData>?) {
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemBinding = ItemPosterDescBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size


    inner class DataViewHolder(private val binding: ItemPosterDescBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DummyData) {
            with(binding) {
                titleFilm.text = data.title
                dateFilm.text = data.date
                genreFilm.text = data.genre
                descFilm.text = data.desc
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, data)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(data.posterImg)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_broken_image))
                    .into(imgPoster)
            }
        }
    }

}