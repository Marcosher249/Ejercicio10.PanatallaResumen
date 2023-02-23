package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityCiudadBinding

class Ciudad : AppCompatActivity() {
    lateinit var binding :ActivityCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button13.setOnClickListener{
            val intent = Intent(this, ContinueCiudad::class.java)
            startActivity(intent)
        }
        binding.button14.setOnClickListener{
            val intent = Intent(this, Dado::class.java)
            startActivity(intent)
        }
        binding.sund.setOnClickListener {
            if (mediaPlayer.isPlaying){
                binding.sund.setImageResource(R.drawable.sound_of)
                mediaPlayer.stop()
            }
            else{
                binding.sund.setImageResource(R.drawable.sound_on)
                mediaPlayer.prepare()
                mediaPlayer.start()
            }
        }
    }
}