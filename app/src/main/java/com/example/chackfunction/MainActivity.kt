package com.example.chackfunction

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    private var soundOne = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val textView = findViewById(R.id.text_view)

        //text_view.setText(R.string.hello)
        val audioAttributes = AudioAttributes.Builder()
            // USAGE_MEDIA
            // USAGE_GAME
            .setUsage(AudioAttributes.USAGE_GAME)
            // CONTENT_TYPE_MUSIC
            // CONTENT_TYPE_SPEECH, etc.
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            // ストリーム数に応じて
            .setMaxStreams(1)
            .build()

        // wav をロードしておく （注）soundファイルは小文字で始めないと認識されない
        soundOne = soundPool.load(this, R.raw.click, 1)

    }


    //--
    fun onClickBtn(view: View) {
        soundPool.play(soundOne, 0.5f, 0.5f, 0, 0, 1.0f)

        if( toggleButton.isChecked) {
            switch1.isChecked = true
            switch2.isChecked = true
        }
        else
        {
            switch1.isChecked = false
            switch2.isChecked = false
        }
    }


}
