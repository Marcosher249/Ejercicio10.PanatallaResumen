package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.ejercicio9panatallaresumen.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Logout : AppCompatActivity() {
    lateinit var binding :ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.logout.setOnClickListener {
            if(binding.editTextTextEmailAddress.text.isNotEmpty() && binding.editTextNumberPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(binding.editTextTextEmailAddress.text.toString(),
                        binding.editTextNumberPassword.text.toString()).addOnCompleteListener{
                        if(it.isSuccessful){
                            showHome()
                        }
                        else{
                            showAlert ()
                        }
                    }
            }
            else{
                showAlert2()
            }
        }
        binding.login.setOnClickListener {
            if(binding.editTextTextEmailAddress.text.isNotEmpty() && binding.editTextNumberPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(binding.editTextTextEmailAddress.text.toString(),
                        binding.editTextNumberPassword.text.toString()).addOnCompleteListener{
                        if(it.isSuccessful){
                            showHome()
                        }else{
                            showAlert ()
                        }
                    }
            }
            else{
                showAlert2 ()
            }
        }
    }

    private fun showAlert (){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autentificar al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlert2 (){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("NO entra en el IF")
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
    private fun showHome(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}