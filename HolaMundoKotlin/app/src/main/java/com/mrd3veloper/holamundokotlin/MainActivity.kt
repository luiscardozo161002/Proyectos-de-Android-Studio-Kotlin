package com.mrd3veloper.holamundokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.EditText // Asegúrate de importar EditText

class MainActivity : AppCompatActivity() {
    lateinit var txtInputNombre: EditText // Declaración de la variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Asignar la vista al elemento txtInputNombre usando findViewById
        txtInputNombre = findViewById(R.id.txtInputNombre)
    }

    fun onClick(view: View) {
        val nombre: String = txtInputNombre.text.toString()
        Toast.makeText(applicationContext, "Bienvenido $nombre al mundo de Kotlin", Toast.LENGTH_LONG).show()
    }
}
