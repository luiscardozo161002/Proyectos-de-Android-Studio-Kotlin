package com.tesji.applibros.Fragmentos_Admin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tesji.applibros.Administrador.AdaptadorCategoria
import com.tesji.applibros.Administrador.Agregar_Categoria
import com.tesji.applibros.Administrador.Agregar_Pdf
import com.tesji.applibros.Administrador.ModeloCategoria
import com.tesji.applibros.databinding.FragmentAdminDashboardBinding

class Fragment_admin_dashboard : Fragment() {

    private lateinit var binding : FragmentAdminDashboardBinding
    private lateinit var mContext : Context
    private lateinit var categoriaArrayList: ArrayList<ModeloCategoria>
    private lateinit var adapatadorCategoria : AdaptadorCategoria


    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAdminDashboardBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ListarCategoria()

        binding.BuscarCategoria.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(categoria: CharSequence?, p1: Int, p2: Int, p3: Int) {
                try {
                    adapatadorCategoria.filter.filter(categoria)
                }catch (e : Exception){

                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.BtnAgregarCategoria.setOnClickListener{
            //startActivity(Intent(mContext, Agregar_Categoria::class.java))
            startActivity(Intent(mContext,Agregar_Categoria::class.java))
        }

        binding.AgregarPdf.setOnClickListener{
            startActivity(Intent(mContext,Agregar_Pdf::class.java))
        }
    }

    private fun ListarCategoria(){
        categoriaArrayList = ArrayList()
        val ref = FirebaseDatabase.getInstance().getReference("Categorias").orderByChild("categoria")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                categoriaArrayList.clear()
                for(ds in snapshot.children){
                    val modelo = ds.getValue(ModeloCategoria::class.java)
                    categoriaArrayList.add(modelo!!)
                }

                adapatadorCategoria = AdaptadorCategoria(mContext, categoriaArrayList)
                binding.categoriasRv.adapter = adapatadorCategoria
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }


}