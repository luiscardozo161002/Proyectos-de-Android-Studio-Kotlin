package com.tesji.applibros.Administrador

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.tesji.applibros.MainActivity
import com.tesji.applibros.R
import com.tesji.applibros.databinding.ActivityLoginAdminBinding

class Login_Admin : AppCompatActivity() {

    //Accedemos a los identificadores del diseño
    private lateinit var binding : ActivityLoginAdminBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere porfavor...")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.IbRegresar.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        binding.BtnLoginAdmin.setOnClickListener{
            ValidarInformacion()
        }
    }

    private var email = ""
    private var password = ""


    private fun ValidarInformacion() {

        email = binding.EtEmailAdmin.text.toString().trim()
        password = binding.EtPasswordAdmin.text.toString().trim()

        if(email.isEmpty()){
            binding.EtEmailAdmin.error = "Ingrese su correo"
            binding.EtEmailAdmin.requestFocus()
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.EtEmailAdmin.error = "Correo inválido"
            binding.EtEmailAdmin.requestFocus()
        }else if(password.isEmpty()){
            binding.EtPasswordAdmin.error = "Ingrese la contraseña"
            binding.EtPasswordAdmin.requestFocus()
        }else{
            LoginAdmin()
        }
    }

    private fun LoginAdmin(){
        progressDialog.setMessage("Iniciando Sesión")
        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //val user = firebaseAuth.currentUser //agregada
                //val verifica = user?.isEmailVerified //agregada
                //if(verifica == true){ //agregada
                    progressDialog.dismiss()
                    startActivity(Intent(this@Login_Admin, MainActivity::class.java))   //Registrar_Admin::class.java  MainActivity::class.java
                    finishAffinity()
                //}else{ //agregada
                  //  Toast.makeText(applicationContext, "No ha verificado su correo", Toast.LENGTH_SHORT).show()
                //}


            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "No se pudo iniciar sesión debido a ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }