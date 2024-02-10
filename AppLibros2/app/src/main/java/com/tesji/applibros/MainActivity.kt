package com.tesji.applibros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.tesji.applibros.Administrador.Registrar_Admin
import com.tesji.applibros.Fragmentos_Admin.Fragment_admin_cuenta
import com.tesji.applibros.Fragmentos_Admin.Fragment_admin_dashboard

//Importamos para obetener el Binding, la solución
import com.tesji.applibros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Declaramos variable para poder usar el ActivityMainBinding
    private lateinit var binding: ActivityMainBinding

    //Para poder cerrar la sesión
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        ComprobarSesion()
        VerFragmentoDashboard()


        //Accede a todos los componentes que tiene nuestra vista "binding"
        binding.BottonNvAdmin.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.Menu_panel->{
                    VerFragmentoDashboard()
                    true
                }
                R.id.Menu_cuenta->{
                    VerFragmentoCuenta()
                    true
                }
                else->{
                    false
                }
            }
        }
    }

    private fun VerFragmentoDashboard(){
        val nombre_titulo = "Dashboard"
        binding.TituloRLAdmin.text = nombre_titulo

        //Se vizualice el fragment dentro del FrameLayout
        val fragment = Fragment_admin_dashboard()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentsAdmin.id, fragment, "Fragment dashboard")
        fragmentTransaction.commit()
    }

    private fun VerFragmentoCuenta(){
        val nombre_titulo = "Mi cuenta"
        binding.TituloRLAdmin.text = nombre_titulo

        //Se vizualice el fragment dentro del FrameLayout
        val fragment = Fragment_admin_cuenta()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentsAdmin.id, fragment, "Fragment mi cuenta")
        fragmentTransaction.commit()
    }


    //Evalua si el usuario existe y lo manda a su rol
    private fun ComprobarSesion(){
        val firebaseUser = firebaseAuth.currentUser
        val verifica = firebaseUser?.isEmailVerified //Agregada
 
        if(verifica == true) { //Agregada

            if (firebaseUser == null) {
                //Si el usuario no existe lo manda a elegir un rol
                if (verifica == true) { //Agregada
                    startActivity(Intent(this, Elegir_rol::class.java))
                    finishAffinity()
                } else {
                    //Le manda un mensaje de Bienvenido(a)
                    //Toast.makeText(applicationContext, "Bienvenido(a) ${firebaseUser.email}",
                    //Toast.LENGTH_SHORT).show()
                }
            }


        } else { //Agregada
            startActivity(Intent(this, Registrar_Admin::class.java))
            Toast.makeText(applicationContext, "Verifique su correo e inicie sesión", Toast.LENGTH_SHORT).show()
        }
   }

}