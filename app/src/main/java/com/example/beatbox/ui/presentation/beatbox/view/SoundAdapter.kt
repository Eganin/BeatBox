package com.example.beatbox.ui.presentation.beatbox.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.beatbox.R
import com.example.beatbox.data.model.entities.BeatBox
import com.example.beatbox.data.model.entities.Sound

class SoundAdapter(private val sounds: List<Sound>,private val beatBox : BeatBox) : RecyclerView.Adapter<SoundHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SoundHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_sound,
                parent,
                false
            ),
            beatBox=beatBox
        )

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        holder.bind(sound = sounds[position])
    }

    override fun getItemCount() = sounds.size
}