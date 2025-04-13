package com.dicoding.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.core.ui.SportsAdapter
import com.dicoding.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.favorite.di.favoriteModule
import com.dicoding.sports.detail.DetailTourismActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        val sportsAdapter = SportsAdapter()
        sportsAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailTourismActivity::class.java)
            intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteTourism.observe(this) { dataTourism ->
            sportsAdapter.submitList(dataTourism)
//            binding.viewEmpty.root.visibility =
//                if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvTourism) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = sportsAdapter
        }
    }
}
