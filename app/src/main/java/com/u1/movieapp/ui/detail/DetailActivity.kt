 package com.u1.movieapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.u1.movieapp.R
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.detail_activity)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
        actionBar.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<DummyData>(EXTRA_DATA) as DummyData
        setView(data)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setView(data: DummyData){
        binding.apply {

            title.text = data.title
            genre.text = data.genre
            duration.text = data.duration
            date.text = data.date
            desc.text = data.desc

            Glide.with(this@DetailActivity)
                    .load(data.posterImg)
                    .apply(
                            RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_broken_image))
                    .into(poster)
        }
    }
}