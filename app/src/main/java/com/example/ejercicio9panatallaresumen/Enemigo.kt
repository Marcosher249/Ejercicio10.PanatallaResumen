package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityEnemigoBinding
import com.example.ejercicio9panatallaresumen.databinding.ActivityMain4Binding

class Enemigo : AppCompatActivity() {
    lateinit var binding : ActivityEnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button15.setOnClickListener{
            val intent = Intent(this, Dado::class.java)
            startActivity(intent)
        }
        binding.button16.setOnClickListener{
            val intent = Intent(this, ContinueEnemigo::class.java)
            startActivity(intent)
        }
    }
}