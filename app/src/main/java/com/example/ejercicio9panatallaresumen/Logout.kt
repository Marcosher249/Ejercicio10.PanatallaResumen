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
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user()
    }

    private fun user() {
        binding.button2.setOnClickListener {
            if (binding.button2.text == "Sing In") {
                singin()
            } else {
                singup()
            }
        }
        binding.button5.setOnClickListener {
            if (binding.button2.text == "Sing In") {
                binding.textView.text = "Registrarse"
                binding.button2.text = "Sing Up"
                binding.button5.text = "Sing In"
            } else {
                binding.textView.text = "Iniciar Sesión"
                binding.button2.text = "Sing In"
                binding.button5.text = "Sing Up"
            }
        }
    }

    private fun singup() {
        binding.button2.setOnClickListener {
            if (binding.editTextTextEmailAddress.text.isNotEmpty() && binding.editTextNumberPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        binding.editTextTextEmailAddress.text.toString(),
                        binding.editTextNumberPassword.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome()
                        } else {
                            showAlert2()
                        }
                    }
            }
        }
    }

    private fun singin() {
        binding.button2.setOnClickListener {
            if (binding.editTextTextEmailAddress.text.isNotEmpty() && binding.editTextNumberPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        binding.editTextTextEmailAddress.text.toString(),
                        binding.editTextNumberPassword.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome()
                        } else {
                            showAlert()
                        }
                    }
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Usuario o contraseña incorrecta")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlert2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("La contraseña tiene que tener munimo 6 caracteres")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}