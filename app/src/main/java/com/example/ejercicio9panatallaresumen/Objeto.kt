package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.ejercicio9panatallaresumen.databinding.ActivityMercadoBinding
import com.example.ejercicio9panatallaresumen.databinding.ActivityObjetoBinding

class Objeto : AppCompatActivity() {
    lateinit var binding :ActivityObjetoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var objeto = Articulo("Object",5,10,10)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundleOf()
        binding.button18.setOnClickListener{
            val intent = Intent(this, Dado::class.java)
            startActivity(intent)
        }
        binding.button17.setOnClickListener{
            val intent = Intent(this, ContinueObjeto::class.java)
            Toast.makeText(this,"Se ha añadido el objeto",Toast.LENGTH_LONG).show()
            personaje.añadirArticulo(objeto)
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

