package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityMain4Binding
import kotlin.random.Random

class Dado : AppCompatActivity() {
    lateinit var binding : ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent = Intent()

        binding.imageButton.setOnClickListener{
            var aleatario = Random.nextInt(1,5)
            when(aleatario){
                1-> intent = Intent(this, Mercado::class.java)
                2-> intent = Intent(this, Enemigo::class.java)
                3-> intent = Intent(this, Ciudad::class.java)
                4-> intent = Intent(this, Objeto::class.java)
            }
            startActivity(intent)
        }
        binding.sund.setOnClickListener {
            if (mediaPlayer.isPlaying){
                binding.sund.setImageResource(R.drawable.sound_of)
                mediaPlayer.pause()
            }
            else{
                binding.sund.setImageResource(R.drawable.sound_on)
                mediaPlayer.start()
            }
        }

    }
}