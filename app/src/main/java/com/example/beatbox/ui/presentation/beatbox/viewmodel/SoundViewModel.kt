package com.example.beatbox.ui.presentation.beatbox.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.beatbox.data.model.entities.Sound

class SoundViewModel : BaseObservable(){

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }

    @get:Bindable
    val title: String?
        get() = sound?.name
}