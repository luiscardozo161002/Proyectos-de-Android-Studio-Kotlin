package com.tesji.appsegurodeautos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var costoFinal = 0.0
    private val model = CalcularSeguroAutosModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas
        val spTipoPolizas = findViewById<Spinner>(R.id.spinnerTipoPolizas)
        val spBebeAlcohol = findViewById<Spinner>(R.id.spinnerBebeAlcohol)
        val spUsaLentes = findViewById<Spinner>(R.id.spinnerUsaLentes)
        val spPadeceEnfermedad = findViewById<Spinner>(R.id.spinnerPadeceEnfermedad)
        val spMayor40Anios = findViewById<Spinner>(R.id.spinnerMayor40Anios)
        val txtMostrarResultado = findViewById<TextView>(R.id.txMostrarResultado)
        val btnCalcularSeguro = findViewById<Button>(R.id.btCalcularSeguro)

        // Configuración de spinners
        val listaTipoPolizas = arrayOf("-Seleccione-", "Cobertura Amplia", "Daños a Terceros")
        val adaptadorTipoPolizas = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaTipoPolizas)
        spTipoPolizas.adapter = adaptadorTipoPolizas

        val listaBebeAlcohol = arrayOf("-Seleccione-", "Si", "No")
        val adaptadorBebeAlcohol = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaBebeAlcohol)
        spBebeAlcohol.adapter = adaptadorBebeAlcohol

        val listaUsoLentes = arrayOf("-Seleccione-", "Si", "No")
        val adaptadorUsoLentes = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaUsoLentes)
        spUsaLentes.adapter = adaptadorUsoLentes

        val listaPadeceEnfermedad = arrayOf("-Seleccione-", "Deficiencia Cardiaca", "Diabetes", "No Padezco")
        val adaptadorPadeceEnfermedad = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPadeceEnfermedad)
        spPadeceEnfermedad.adapter = adaptadorPadeceEnfermedad

        val listaMayor40anios = arrayOf("-Seleccione-", "Si", "No")
        val adaptadorMayor40anios = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaMayor40anios)
        spMayor40Anios.adapter = adaptadorMayor40anios


        // Definir un OnItemSelectedListener para el Spinner spTipoPolizas
        spTipoPolizas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Obtener el elemento seleccionado
                val elementoSeleccionadoTipoPolizas = listaTipoPolizas[position]

                // Aquí puedes realizar acciones basadas en el elemento seleccionado
                // Por ejemplo, mostrarlo en un TextView
                //txtMostrarResultado.text = elementoSeleccionadoTipoPolizas
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Este método se llama cuando no se ha seleccionado ningún elemento
            }
        }


        // Definir un OnItemSelectedListener para el Spinner spBebeAlcohol
        spBebeAlcohol.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Obtener el elemento seleccionado
                val elementoSeleccionadoBebeAlcohol = listaBebeAlcohol[position]

                // Aquí puedes realizar acciones basadas en el elemento seleccionado
                // Por ejemplo, mostrarlo en un TextView
                //txtMostrarResultado.text = elementoSeleccionadoBebeAlcohol
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Este método se llama cuando no se ha seleccionado ningún elemento
            }
        }

        // Definir un OnItemSelectedListener para el Spinner spUsaLentes
        spUsaLentes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Obtener el elemento seleccionado
                val elementoSeleccionadoUsaLentes = listaUsoLentes[position]

                // Aquí puedes realizar acciones basadas en el elemento seleccionado
                // Por ejemplo, mostrarlo en un TextView
                //txtMostrarResultado.text = elementoSeleccionadoUsaLentes
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Este método se llama cuando no se ha seleccionado ningún elemento
            }
        }


        // Definir un OnItemSelectedListener para el Spinner spPadeceEnfermedad
        spPadeceEnfermedad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Obtener el elemento seleccionado
                val elementoSeleccionadoPadeceEnfermedad = listaPadeceEnfermedad[position]

                // Aquí puedes realizar acciones basadas en el elemento seleccionado
                // Por ejemplo, mostrarlo en un TextView
                //txtMostrarResultado.text = elementoSeleccionadoPadeceEnfermedad
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Este método se llama cuando no se ha seleccionado ningún elemento
            }
        }

        // Definir un OnItemSelectedListener para el Spinner spMayor40anios
        spMayor40Anios.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Obtener el elemento seleccionado
                val elementoSeleccionadoMayor40anios = listaMayor40anios[position]

                // Aquí puedes realizar acciones basadas en el elemento seleccionado
                // Por ejemplo, mostrarlo en un TextView
                //txtMostrarResultado.text = elementoSeleccionadoMayor40anios
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Este método se llama cuando no se ha seleccionado ningún elemento
            }
        }

        // Crear el evento clic del botón
        btnCalcularSeguro.setOnClickListener {
            val tipoPoliza = spTipoPolizas.selectedItem.toString()
            val bebeAlcohol = spBebeAlcohol.selectedItem.toString()
            val usaLentes = spUsaLentes.selectedItem.toString()
            val padeceEnfermedad = spPadeceEnfermedad.selectedItem.toString()
            val mayor40Anios = spMayor40Anios.selectedItem.toString()

            if (model.validateInputs(tipoPoliza, bebeAlcohol, usaLentes, padeceEnfermedad, mayor40Anios)) {
                costoFinal = model.calculateInsuranceCost(tipoPoliza, bebeAlcohol, usaLentes, padeceEnfermedad, mayor40Anios)

                // Mostrar el resultado en el TextView
                txtMostrarResultado.text = "Precio Contrato Poliza: $" + costoFinal.toString() +
                        "\nTipo Poliza: " + tipoPoliza +
                        "\n¿Bebe alcohol?: " + bebeAlcohol +
                        "\n¿Utiliza, lentes?: " + usaLentes +
                        "\n¿Padece alguna enfermedad?: " + padeceEnfermedad +
                        "\n¿Tienes +40 años?: " + mayor40Anios
            } else {
                // Mostrar un mensaje de error
                txtMostrarResultado.text = "ERROR: SELECCIONE OPCIONES VALIDAS"
            }
        }
    }
}
