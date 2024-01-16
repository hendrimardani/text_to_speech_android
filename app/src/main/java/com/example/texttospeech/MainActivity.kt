package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import com.example.texttospeech.databinding.ActivityMainBinding
import java.util.Locale

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var tts: TextToSpeech
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSpeaker.setOnClickListener {
            println("TERKLIK !!!!!")
            Log.e("System.out", "TERKLIK CUYY!!")
            Log.w("System.out", "TERKLIK CUYY!!")
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS) {
                    tts.language = Locale.US
                    tts.setSpeechRate(1.0f)
                    tts.speak(binding.etText.text.toString(),TextToSpeech.QUEUE_ADD, null )
                }
            })

        }
    }
}