package com.tesji.miprimeraappenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_actividad)  //Se genero un identificador con el nombre del segundo xml
    }
}