package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio9panatallaresumen.databinding.ActivityMercadoBinding
import com.example.ejercicio9panatallaresumen.databinding.ActivityObjetoBinding

class Objeto : AppCompatActivity() {
    lateinit var binding :ActivityObjetoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button18.setOnClickListener{
            val intent = Intent(this, Dado::class.java)
            startActivity(intent)
        }
        binding.button17.setOnClickListener{
            val intent = Intent(this, ContinueObjeto::class.java)
            startActivity(intent)
        }
    }
}