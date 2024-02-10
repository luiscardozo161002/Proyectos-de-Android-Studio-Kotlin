package com.tesji.applibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.tesji.applibros.Administrador.Constantes
import com.tesji.applibros.databinding.ActivityLeerLibroBinding

class LeerLibro : AppCompatActivity() {

    private lateinit var binding : ActivityLeerLibroBinding

    var idLibro = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeerLibroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idLibro = intent.getStringExtra("idLibro")!!


        binding.IbRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        cargarInformacionLibro()

    }

    private fun cargarInformacionLibro() {
        val ref = FirebaseDatabase.getInstance().getReference("Libros")
        ref.child(idLibro)
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val pdfUrl = snapshot.child("url").value
                    cargarLibroStogare("$pdfUrl")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
    }

    private fun cargarLibroStogare(pdfUrl: String) {
        val reference = FirebaseStorage.getInstance().getReferenceFromUrl(pdfUrl)
        reference.getBytes(Constantes.Maximo_bytes_pdf)
            .addOnSuccessListener {bytes->
                //Cargar el pdf
                binding.VisualizadorPDF.fromBytes(bytes)
                    .swipeHorizontal(false)
                    .onPageChange{pagina, contadorPaginas->
                        val paginaActual = pagina+1
                        binding.TxtLeerLibro.text = "$paginaActual/$contadorPaginas"
                    }
                    .load()
                binding.progressBar.visibility = View.GONE
            }
            .addOnFailureListener { e->
                binding.progressBar.visibility = View.GONE
            }
    }
}