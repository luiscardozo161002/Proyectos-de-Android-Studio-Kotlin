package com.tesji.applibros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tesji.applibros.Administrador.Registrar_Admin
import com.tesji.applibros.databinding.ActivityElegirRolBinding



class Elegir_rol : AppCompatActivity() {

    private lateinit var binding: ActivityElegirRolBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElegirRolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Evento para el boton de BtnRolAdministrador
        binding.BtnRolAdministrador.setOnClickListener{
            //Toast.makeText(applicationContext, "Rol Administrador", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@Elegir_rol, Registrar_Admin::class.java))
        }

        //Evento para el boton de BtnRolClienta
        //binding.BtnRolCliente.setOnClickListener{
            //Toast.makeText(applicationContext, "Rol Cliente", Toast.LENGTH_SHORT).show()
        //}


    }
}