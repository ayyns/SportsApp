package com.dicoding.sports.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import com.bumptech.glide.Glide
import com.dicoding.sports.R
import com.dicoding.core.domain.model.Sports
import com.dicoding.sports.databinding.ActivityDetailTourismBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTourismActivity : AppCompatActivity() {

   private val detailTourismViewModel: DetailTourismViewModel by viewModel()
    private lateinit var binding: ActivityDetailTourismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val detailSports = getParcelableExtra(intent, EXTRA_DATA, Sports::class.java)
        showDetailTourism(detailSports)
    }

    private fun showDetailTourism(detailSports: Sports?) {
        detailSports?.let {
            supportActionBar?.title = detailSports.name
            binding.contentDetailTourism.tvDetailDescription.text = detailSports.description
            Glide.with(this@DetailTourismActivity)
                .load(detailSports.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailSports.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteTourism(detailSports, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
