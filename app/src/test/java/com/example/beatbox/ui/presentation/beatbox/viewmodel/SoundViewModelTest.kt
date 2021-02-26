package com.example.beatbox.ui.presentation.beatbox.viewmodel

import com.example.beatbox.data.model.entities.BeatBox
import com.example.beatbox.data.model.entities.Sound
import org.hamcrest.core.Is.`is`
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    private lateinit var sound : Sound
    private lateinit var subject : SoundViewModel
    private lateinit var beatBox : BeatBox

    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        sound = Sound(assetPath ="assetPath")
        subject = SoundViewModel(beatBox=beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle(){
        assertThat(subject.title,`is`(sound.name))
    }

    @Test
    fun callsBeatBoxPlay(){
        subject.onButtonClicked()
        /*
        Проверка что onButtonCLiked вызывает BeatBox.play(sound)
         */
        verify(beatBox).play(sound=sound)
    }
}