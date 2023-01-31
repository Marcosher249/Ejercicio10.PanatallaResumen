package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityMain3Binding
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val clase = bundle?.getInt("clase")
        val especie = bundle?.getInt("especie")
        binding.imageView3.setImageResource(clase!!)
        binding.imageView4.setImageResource(especie!!)
        binding.button12.setOnClickListener {
            val intent = Intent(this, Dado::class.java)
            startActivity(intent)
        }
        binding.button6.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.textView6.text = Random.nextInt(10,15).toString()
        binding.textView7.text = Random.nextInt(1,5).toString()

    }
}