package com.tesji.apphotelguamchil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tesji.apphotelguamchil.model.CalcularCotizacionDiasHotel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtNumeroDias = findViewById<EditText>(R.id.txNumeroDias);
        val txtPrecioDiarioHabitacion = findViewById<EditText>(R.id.txPrecioDiarioHabitacion);
        val btnCalcularCotizacion = findViewById<Button>(R.id.btCalcularCotizacion);
        val txtResultadoCotizacion = findViewById<TextView>(R.id.txMostrarResultado)

        // Crear el evento clic del botón
        btnCalcularCotizacion.setOnClickListener {

            if(txtNumeroDias.text.toString().trim().isEmpty() && txtPrecioDiarioHabitacion.text.toString().trim().isEmpty()){
                Toast.makeText(getApplicationContext(),
                    "INGRESA DIAS Y PRECIO DE HOSPEDAJE", Toast.LENGTH_LONG).show();
            }else if (txtNumeroDias.text.toString().trim()
                .isEmpty()) {
                txtNumeroDias.setError("INGRESA UN NÚMERO DE DIAS")
            } else if (txtPrecioDiarioHabitacion.text.toString().trim().isEmpty()) {
                txtPrecioDiarioHabitacion.setError("INGRESA UN PRECIO DE HABITACIÓN")
            } else {
                // Conectar con el Modelo
                val CalcularCotizacionDiasHotel = CalcularCotizacionDiasHotel()
                CalcularCotizacionDiasHotel.setNumeroDias(Integer.parseInt(txtNumeroDias.text.toString()))
                CalcularCotizacionDiasHotel.setPrecioHabitacionDia(txtPrecioDiarioHabitacion.text.toString().toDouble())

                // Realiza el cálculo
                val resultado = CalcularCotizacionDiasHotel.CalcularCotizacionDiasHotel()

                // Muestra el resultado en el TextView
                txtResultadoCotizacion.text = resultado
            }
        }
    }
}