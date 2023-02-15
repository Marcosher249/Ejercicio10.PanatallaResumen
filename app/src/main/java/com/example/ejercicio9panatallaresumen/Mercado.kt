package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.ejercicio9panatallaresumen.databinding.ActivityMainBinding
import com.example.ejercicio9panatallaresumen.databinding.ActivityMercadoBinding

class Mercado : AppCompatActivity() {
    lateinit var binding : ActivityMercadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMercadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var cantidad = 0
        val precio = binding.textView15.text.toString().toInt()
        binding.continuar.setOnClickListener{
            val intent = Intent(this, Dado::class.java)
            startActivity(intent)
        }
        binding.comerciar.setOnClickListener{
            binding.comerciar.isVisible = false
            binding.continuar.isVisible = false
            binding.comprar.isVisible = true
            binding.vemder.isVisible = true
            binding.cancelar.isVisible = true
            binding.textView17.isVisible = false
            binding.textView16.isVisible = false
            binding.textView15.isVisible = false
            binding.textView14.isVisible = false
        }
        binding.cancelar.setOnClickListener{
            binding.imageView9.setImageResource(R.drawable.mercado)
            binding.textView17.text = "0"
            binding.textView12.text = "0"
            binding.mas.isVisible = false
            binding.menos.isVisible = false
            binding.textView12.isVisible = false
            binding.comerciar.isVisible = true
            binding.continuar.isVisible = true
            binding.comprar.isVisible = false
            binding.vemder.isVisible = false
            binding.cancelar.isVisible = false
            binding.textView17.isVisible = false
            binding.textView16.isVisible = false
            binding.textView15.isVisible = false
            binding.textView14.isVisible = false
        }
        binding.comprar.setOnClickListener {
            binding.imageView9.setImageResource(R.drawable.objeto)
            binding.textView16.text = "Precio:"
            binding.textView17.text = "0"
            binding.textView12.text = "125"
            binding.textView17.isVisible = true
            binding.textView16.isVisible = true
            binding.textView15.isVisible = true
            binding.textView14.isVisible = true
            binding.mas.isVisible = true
            binding.menos.isVisible = true
            binding.textView12.isVisible = true

        }
        binding.mas.setOnClickListener {
            if (cantidad < 100) {
                binding.textView12.text = (cantidad + 1).toString()
                cantidad = (binding.textView12.text).toString().toInt()
                binding.textView17.text = (cantidad * precio).toString()
            }
        }
        binding.menos.setOnClickListener{
            if (cantidad>0){
                binding.textView12.text = (cantidad - 1).toString()
                cantidad = (binding.textView12.text).toString().toInt()
                binding.textView17.text = (cantidad * precio).toString()
            }

        }
        binding.vemder.setOnClickListener {
            binding.imageView9.setImageResource(R.drawable.esponja)
            binding.textView17.text = personaje.total().toString()
            binding.textView15.text = personaje.getSice().toString()
            binding.textView16.text = "Objetos:"
            binding.textView12.text = "0"
            binding.mas.isVisible = false
            binding.menos.isVisible = false
            binding.textView12.isVisible = false
            binding.textView17.isVisible = true
            binding.textView16.isVisible = true
            binding.textView15.isVisible = true
            binding.textView14.isVisible = true
            if(personaje.getSice()==0){
                Toast.makeText(this,"La mochila esta vacia", Toast.LENGTH_LONG).show()
            }
        }






    }
}