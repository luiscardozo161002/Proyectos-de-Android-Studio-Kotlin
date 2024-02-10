package com.tesji.applibros.Administrador

import android.app.Application
import android.app.ProgressDialog
import android.content.Context
import android.text.format.DateFormat
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.util.Calendar
import java.util.Locale

class MisFunciones : Application(){

    override fun onCreate() {
        super.onCreate()
    }

    companion object{

        //Permite convertir el formato del tiempo
        fun formatoTiempo(tiempo : Long) : String{
            val cal = Calendar.getInstance(Locale.ENGLISH)
            cal.timeInMillis = tiempo
            //dd/MM/yyyy
            return  DateFormat.format("dd/MM/yyyy", cal).toString()
        }

        //Permite cargar el tamaño del PDF
        fun CargarTamanioPdf(pdfUrl : String, pdfTitulo : String, tamanio : TextView){
            val ref = FirebaseStorage.getInstance().getReferenceFromUrl(pdfUrl)
            ref.metadata
                .addOnSuccessListener {metadata->
                    val bytes = metadata.sizeBytes.toDouble()

                    val KB = bytes/1024
                    val MB = KB/1024

                    if(MB>1){
                        tamanio.text = "${String.format("%.2f", MB)} MB"
                    } else if(KB>=1){
                        tamanio.text = "${String.format("%.2f", KB)} MB"
                    }else{
                        tamanio.text = "${String.format("%.2f", bytes)} Bytes"
                    }

                }
                .addOnFailureListener {e->

                }

        }

        //Permite cargar el pdf a través de una URL
        fun CargarPdfUrl(pdfUrl: String, pdfTitulo: String, pdfView: PDFView, progressBar: ProgressBar,
                         paginaTv : TextView?){
            val ref = FirebaseStorage.getInstance().getReferenceFromUrl(pdfUrl)
            ref.getBytes(Constantes.Maximo_bytes_pdf)
                .addOnSuccessListener {bytes->
                    pdfView.fromBytes(bytes)
                        .pages(0)
                        .spacing(0)
                        .swipeHorizontal(false)
                        .enableSwipe(false)
                        .onError {t->
                            progressBar.visibility = View.INVISIBLE
                        }
                        .onPageError { page, pageCount ->
                            progressBar.visibility = View.INVISIBLE
                        }
                        .onLoad { Pagina->
                            progressBar.visibility = View.INVISIBLE
                            if(paginaTv != null){
                                paginaTv.text = "$Pagina"
                            }
                        }
                        .load()
                }
                .addOnFailureListener {e->

                }
        }

        //Permite visualizar la categoria
        fun CargarCategoria(categoriaId : String, categoriaTv : TextView){
            val ref = FirebaseDatabase.getInstance().getReference("Categorias")
            ref.child(categoriaId)
                .addListenerForSingleValueEvent(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) { //Obtenemos la categoria
                        val categoria = "${snapshot.child("categoria").value}"
                        categoriaTv.text = categoria
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }
                })
        }

        //Permite eliminar libro
        fun EliminarLibro(context : Context, idLibro : String, urlLibro : String, tituloLibro : String){
            val progressDialog = ProgressDialog(context)
            progressDialog.setTitle("Espere por favor...")
            progressDialog.setMessage("Eliminando $tituloLibro")
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            val storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(urlLibro)
            storageReference.delete()
                .addOnSuccessListener {
                    val ref = FirebaseDatabase.getInstance().getReference("Libros")
                    ref.child(idLibro)
                        .removeValue()
                        .addOnSuccessListener {
                            progressDialog.dismiss()
                            Toast.makeText(context, "El libro se ha eliminado", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {e->
                            progressDialog.dismiss()
                            Toast.makeText(context, "Falló la eliminación debido a ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
                .addOnFailureListener {e->
                    progressDialog.dismiss()
                    Toast.makeText(context, "Falló la eliminación debido a ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }

    }
}