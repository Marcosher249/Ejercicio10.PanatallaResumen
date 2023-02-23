package com.example.ejercicio9panatallaresumen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityContinueEnemigoBinding

class ContinueEnemigo : AppCompatActivity() {
    lateinit var binding : ActivityContinueEnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContinueEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}