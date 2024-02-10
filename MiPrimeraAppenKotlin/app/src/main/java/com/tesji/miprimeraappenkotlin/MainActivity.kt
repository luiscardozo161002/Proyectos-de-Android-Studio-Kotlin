package com.tesji.miprimeraappenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tesji.miprimeraappenkotlin.model.TerrenoModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        println("¡¡Hola Mundo desde Kotlin!!")
        println("Creado por Luis Cardozo")

        // Variables en kotlin
        // Kotlin puedes ser tipado o no

        // var: declara una variable
        var nombre:String = "Luis Gerardo Cardozo Carranza";
        var salario:Double = 25000.00;

        // val: declara constantes (MAYUSCULAS)
        val PI = 3.1416
        //Scope: Todo lo que vive dentro de las llaves en una función
        if(true){
            var nombre = "Luis"
            nombre = "Juan"
        }
        */

        // Controlador para la GUI y el modelo

        // Declarar los Views y referenciarlos por su ID
        val txtNombre = findViewById<EditText>(R.id.txNombre)
        val txtMedidaAncho = findViewById<EditText>(R.id.txMedidaAncho)
        val txtMedidaLargo = findViewById<EditText>(R.id.txMedidaLargo)
        val txtPrecioMetro = findViewById<EditText>(R.id.txPrecioMetro)
        val btnCalcular = findViewById<Button>(R.id.btCalcular)

        //Crear el evento clic del boton
        btnCalcular.setOnClickListener{
                                        //Elima espacios y devuelve caracteres
            if(txtNombre.text.toString().trim().isEmpty()){
                txtNombre.setError("Ingrese Nombre")
            }else if(txtMedidaAncho.text.toString().trim().isEmpty()){
                txtMedidaAncho.setError("Ingrese Medida de Ancho")
            }else if(txtMedidaLargo.text.toString().trim().isEmpty()){
                txtMedidaLargo.setError("Ingrese Medida de Largo")
            }else if(txtPrecioMetro.text.toString().trim().isEmpty()){
                txtPrecioMetro.setError("Ingrese Precio de Metro")
            }else{
                // Conectar con el Modelo
                val terreno = TerrenoModel();
                terreno.nombre = txtNombre.text.toString()
                terreno.medidaLargo = txtMedidaLargo.text.toString().toDouble()
                terreno.medidaAncho = txtMedidaAncho.text.toString().toDouble()
                terreno.precioMetro = txtPrecioMetro.text.toString().toDouble()

                Toast.makeText(applicationContext, terreno.calcularVenta(), Toast.LENGTH_LONG).show()
            }

        }

    }
}

