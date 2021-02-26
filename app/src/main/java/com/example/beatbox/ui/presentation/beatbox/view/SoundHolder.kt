package com.example.beatbox.ui.presentation.beatbox.view

import androidx.recyclerview.widget.RecyclerView
import com.example.beatbox.data.model.entities.BeatBox
import com.example.beatbox.data.model.entities.Sound
import com.example.beatbox.databinding.ListItemSoundBinding
import com.example.beatbox.ui.presentation.beatbox.viewmodel.SoundViewModel

class SoundHolder(private val binding: ListItemSoundBinding,private val beatBox : BeatBox) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.viewModel = SoundViewModel(beatBox = beatBox)
    }

    fun bind(sound : Sound){
        binding.apply {
            viewModel?.sound = sound
            executePendingBindings()
        }
    }
}