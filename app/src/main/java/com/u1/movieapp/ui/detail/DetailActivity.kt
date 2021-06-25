 package com.u1.movieapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Element
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.u1.movieapp.R
import com.u1.movieapp.data.model.DetailModel
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.databinding.ActivityDetailBinding
import com.u1.movieapp.utils.ConstantVal.IMG_URL
import com.u1.movieapp.utils.ViewModelFactory

 class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var binding : ActivityDetailBinding

    private lateinit var viewModel: DetailViewModel

    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.detail_activity)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back)
        actionBar.setDisplayHomeAsUpEnabled(true)

        viewModelFactory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]

        val dataId = intent.getStringExtra(EXTRA_DATA)
        val dataType = intent.getIntExtra(EXTRA_TYPE, -1)
        checkingData(dataId, dataType)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun checkingData(dataId: String?, dataType: Int){
        if (dataId != null && dataType != -1){
            viewModel.setSelectedFilm(dataId, dataType)
            viewModel.getSelectedFilm().observe(this, { detailData ->
                setView(detailData)
            })
        }
    }

    private fun setView(data: DetailModel){
        binding.apply {
            title.text = data.title
            genre.text = data.genres!!.joinToString()
            date.text = data.year
            desc.text = data.overview

            Glide.with(this@DetailActivity)
                    .load(IMG_URL + data.poster)
                    .apply(
                            RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_broken_image))
                    .into(poster)
        }
    }
}