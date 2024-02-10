package com.kube.practica1_alexandermartinez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.kube.practica1_alexandermartinez.model.CalcularPrestaciones

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaración de variables
        val txtNombre = findViewById<EditText>(R.id.txnombre)
        val txtSueldo = findViewById<EditText>(R.id.txsalario)
        val txtAnio = findViewById<EditText>(R.id.txanio)
        val btnCalcular = findViewById<Button>(R.id.btcalcu)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        val mesesTrabajados = mutableListOf<EditText>(
            findViewById(R.id.txEnero),
            findViewById(R.id.txFebrero),
            findViewById(R.id.txMarzo),
            findViewById(R.id.txAbril),
            findViewById(R.id.txMayo),
            findViewById(R.id.txJunio),
            findViewById(R.id.txJulio),
            findViewById(R.id.txAgosto),
            findViewById(R.id.txSeptiembre),
            findViewById(R.id.txOctubre),
            findViewById(R.id.txNoviembre),
            findViewById(R.id.txDiciembre)
        )

        btnCalcular.setOnClickListener {
            // Validaciones de entrada
            if (txtNombre.text.toString().trim().isEmpty() ||
                txtSueldo.text.toString().trim().isEmpty() ||
                txtAnio.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(this, "Ingrese todos los campos obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Inicialización de variables
            var diasTrabajados = 0
            var sueldopordia = 0.0
            var sueldopordiatot = 0.0
            var mesesTrabajadosCount = 0
            var anioTrabajo = txtAnio.text.toString().toInt()
            var esAnioBisiesto = anioTrabajo % 4 == 0
            var diasPorMes = intArrayOf(31, if (esAnioBisiesto) 29 else 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

            // Validaciones de meses trabajados
            for ((index, editText) in mesesTrabajados.withIndex()) {
                val dias = editText.text.toString().toInt()
                val saldotot = txtSueldo.text.toString().toInt()
                if (dias < 0 || dias > diasPorMes[index]) {
                    editText.setError("Ingrese un valor válido")
                    return@setOnClickListener
                }

                diasTrabajados += dias
                if (dias == 0) {
                    mesesTrabajadosCount++
                }
                sueldopordia += (saldotot / diasPorMes[index])
            }
            sueldopordiatot += sueldopordia / 12

            // Conectar con el modelo
            val prestaciones = CalcularPrestaciones().apply {
                nombre = txtNombre.text.toString()
                sueldo = sueldopordiatot
                meses = mesesTrabajadosCount.toDouble()
                dias = diasTrabajados.toDouble()
                anio = anioTrabajo
                anio2 = if (esAnioBisiesto) 366 else 365
            }

            resultadoTextView.text = prestaciones.calcularPrestacion()
        }
    }
}
