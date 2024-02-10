package com.tesji.practica1_juanmanuel_miguelisidro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tesji.practica1_juanmanuel_miguelisidro.model.PrestacionModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaracion de views

        // Principales
        val txtAno = findViewById<EditText>(R.id.txtAno)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtSalario = findViewById<EditText>(R.id.txtSalario)


        // Meses
        val txtEnero = findViewById<EditText>(R.id.txtEnero)
        val txtFebrero = findViewById<EditText>(R.id.txtFebrero)
        val txtMarzo = findViewById<EditText>(R.id.txtMarzo)
        val txtAbril = findViewById<EditText>(R.id.txtAbril)
        val txtMayo = findViewById<EditText>(R.id.txtMayo)
        val txtJunio = findViewById<EditText>(R.id.txtJunio)
        val txtJulio = findViewById<EditText>(R.id.txtJulio)
        val txtAgosto = findViewById<EditText>(R.id.txtAgosto)
        val txtSeptiembre = findViewById<EditText>(R.id.txtSeptiembre)
        val txtOctubre = findViewById<EditText>(R.id.txtOctubre)
        val txtNoviembre = findViewById<EditText>(R.id.txtNoviembre)
        val txtDiciembre = findViewById<EditText>(R.id.txtDiciembre)

        val textView = findViewById<TextView>(R.id.textView)
        // Boton
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        // Evento clic del boton
        btnCalcular.setOnClickListener() {

            // Conexion al modelo
            val prestacion = PrestacionModel()

            // Campos no vacios de los campos
            if(txtNombre.text.toString().trim().isEmpty()){
                txtNombre.setError("¿Y tu nombre papu?")
            }else{
                prestacion.nombre = txtNombre.text.toString()
            }
            if(txtAno.text.toString().trim().isEmpty()){
                txtAno.setError("El año donde esta a poco eres viajero del tiempo")
            }else{
                prestacion.ano = txtAno.text.toString().toInt()
            }
            if(txtSalario.text.toString().trim().isEmpty()){
                txtSalario.setError("Y el pago papi, que no te de verguenza")
            }else{
                prestacion.salario = txtSalario.text.toString().toDouble()
            }
            // Campos no vacios de los meses
            if(txtEnero.text.toString().trim().isEmpty()){
                txtEnero.setError("Faltan los dias")
            }else{
                prestacion.enero = txtEnero.text.toString().toInt()
            }
            if(txtFebrero.text.toString().trim().isEmpty()){
                txtFebrero.setError("Faltan los dias")
            }else{
                prestacion.febrero = txtFebrero.text.toString().toInt()
            }
            if(txtMarzo.text.toString().trim().isEmpty()){
                txtMarzo.setError("Faltan los dias")
            }else{
                prestacion.marzo = txtMarzo.text.toString().toInt()
            }
            if(txtAbril.text.toString().trim().isEmpty()){
                txtAbril.setError("Faltan los dias")
            }else{
                prestacion.abril = txtAbril.text.toString().toInt()
            }
            if(txtMayo.text.toString().trim().isEmpty()){
                txtMayo.setError("Faltan los dias")
            }else{
                prestacion.mayo = txtMayo.text.toString().toInt()
            }
            if(txtJunio.text.toString().trim().isEmpty()){
                txtJunio.setError("Faltan los dias")
            }else{
                prestacion.junio = txtJunio.text.toString().toInt()
            }
            if(txtJulio.text.toString().trim().isEmpty()){
                txtJulio.setError("Faltan los dias")
            }else{
                prestacion.julio = txtJulio.text.toString().toInt()
            }
            if(txtAgosto.text.toString().trim().isEmpty()){
                txtAgosto.setError("Faltan los dias")
            }else{
                prestacion.agosto = txtAgosto.text.toString().toInt()
            }
            if(txtSeptiembre.text.toString().trim().isEmpty()){
                txtSeptiembre.setError("Faltan los dias")
            }else{
                prestacion.septiembre = txtSeptiembre.text.toString().toInt()
            }
            if(txtOctubre.text.toString().trim().isEmpty()){
                txtOctubre.setError("Faltan los dias")
            }else{
                prestacion.octubre = txtOctubre.text.toString().toInt()
            }
            if(txtNoviembre.text.toString().trim().isEmpty()){
                txtNoviembre.setError("Faltan los dias")
            }else{
                prestacion.noviembre = txtNoviembre.text.toString().toInt()
            }
            if(txtDiciembre.text.toString().trim().isEmpty()){
                txtDiciembre.setError("Faltan los dias")
            }else{
                prestacion.diciembre = txtDiciembre.text.toString().toInt()
            }

            // Impresion de resultados

            textView.text = prestacion.calcularPrestaciones()
        }

        /*En este ejemplo, R.id.textView es el ID del TextView en tu archivo de diseño XML. Asegúrate de reemplazarlo con el ID correcto de tu TextView.
        También puedes utilizar el operador de acceso directo findViewById para obtener la referencia al TextView en tu actividad. Luego, puedes llamar al método
        setText() en esa referencia para establecer el texto deseado.
        Recuerda que este código debe ejecutarse después de que el TextView haya sido inflado en tu actividad, por ejemplo, en el método onCreate().*/

    }
}