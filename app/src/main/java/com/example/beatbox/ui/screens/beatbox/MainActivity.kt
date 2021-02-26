package com.example.beatbox.ui.screens.beatbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.beatbox.R
import com.example.beatbox.data.model.entities.BeatBox
import com.example.beatbox.databinding.ActivityMainBinding
import com.example.beatbox.ui.presentation.beatbox.view.SoundAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var beatBox: BeatBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        beatBox = BeatBox(assets=assets)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.mainRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = SoundAdapter(sounds=beatBox.sounds)
        }
    }
}