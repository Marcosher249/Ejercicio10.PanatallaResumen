package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var especie:Int= 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val clase = bundle?.getInt("clase")

        binding.imageView2.setImageResource(R.drawable.seleccion)
        binding.button7.setOnClickListener{
            binding.imageView2.setImageResource(R.drawable.humano)
            especie = R.drawable.humano
        }
        binding.button8.setOnClickListener(){
            binding.imageView2.setImageResource(R.drawable.elfo)
            especie = R.drawable.elfo
        }
        binding.button9.setOnClickListener(){
            binding.imageView2.setImageResource(R.drawable.enano)
            especie = R.drawable.enano
        }
        binding.button10.setOnClickListener(){
            binding.imageView2.setImageResource(R.drawable.goblin)
            especie = R.drawable.goblin
        }
        binding.button11.setOnClickListener(){
            if (especie != 0 ) {
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("especie",especie)
                intent.putExtra("clase", clase)
                startActivity(intent)
            }
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