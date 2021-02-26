package com.example.beatbox.data.model.entities

import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException

private const val TAG = "BeatBox"
private const val SOUNDS_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 5

//AssetManager - используется для доступа к assets
class BeatBox(private val assets: AssetManager) {

    private val soundPool = SoundPool.Builder()
        .setMaxStreams(MAX_SOUNDS)
        .build()

    val sounds: List<Sound> get() = loadSounds()

    fun play(sound: Sound) {
        sound.soundId?.let {
            soundPool.play(it, 1.0f, 1.0f, 1, 0, 1.0f)
        }
    }

    private fun loadSounds(): List<Sound> {

        val soundNames: Array<String>

        try {
            soundNames = assets.list(SOUNDS_FOLDER)!!
        } catch (e: Exception) {
            Log.e(TAG, "not assets")
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()
        soundNames.forEach {
            val assetPath = "$SOUNDS_FOLDER/$it"
            val sound = Sound(assetPath = assetPath)
            try {
                load(sound = sound)
                sounds.add(sound)
            } catch (e: IOException) {
                Log.e(TAG, "not load sound")
            }
        }

        return sounds
    }

    private fun load(sound: Sound) {
        // открываем файловый дескриптор
        val afd = assets.openFd(sound.assetPath)
        //загрудажаем файл в  soundPool для проигрывания
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId
    }
}