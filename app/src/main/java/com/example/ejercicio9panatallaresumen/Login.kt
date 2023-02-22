package com.example.ejercicio9panatallaresumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import java.security.Provider

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logear()
    }
    private fun logear (){
        val button:Button
        val correo:TextView
        val contraseña:TextView
        correo = findViewById(R.id.editTextTextEmailAddress)
        contraseña = findViewById(R.id.editTextNumberPassword)
        button = findViewById(R.id.singIn)
        button.setOnClickListener {
            if(correo.text.isEmpty() && contraseña.text.isEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo.text.toString(),contraseña.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){

                    }else{
                        showAlert()
                    }
                }
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
    private fun showHome(correo:String,provider:Provider){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}