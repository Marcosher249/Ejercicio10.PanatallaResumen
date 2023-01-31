package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityMainBinding
import com.example.ejercicio9panatallaresumen.databinding.ActivityMercadoBinding

class Mercado : AppCompatActivity() {
    lateinit var binding : ActivityMercadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button20.setOnClickListener{
            val intent = Intent(this, Dado::class.java)
            startActivity(intent)
        }
        binding.button19.setOnClickListener{
            val intent = Intent(this, ContinueMercado::class.java)
            startActivity(intent)
        }
    }
}