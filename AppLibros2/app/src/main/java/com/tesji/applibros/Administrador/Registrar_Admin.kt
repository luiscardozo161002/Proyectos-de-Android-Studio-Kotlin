package com.tesji.applibros.Administrador

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.FirebaseDatabaseKtxRegistrar
import com.tesji.applibros.MainActivity
import com.tesji.applibros.R
import com.tesji.applibros.databinding.ActivityElegirRolBinding
import com.tesji.applibros.databinding.ActivityRegistrarAdminBinding

class Registrar_Admin : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarAdminBinding

    //Importacion de la autenticación
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere porfavor...")
        progressDialog.setCanceledOnTouchOutside(false)


        //Evento para regresar
        binding.IbRegresar.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        //Evento para registrar al administrador
        binding.BtnRegistrarAdmin.setOnClickListener(){
            ValidarInformacion()
        }

        //Lo enviará a la parte del iniciar sesión si tien cuenta
        binding.TxtTengoCuenta.setOnClickListener{
            startActivity(Intent(this@Registrar_Admin, Login_Admin::class.java))
        }

    }

    var nombres = ""
    var email = ""
    var password = ""
    var r_password = ""

    private fun ValidarInformacion(){
        nombres = binding.EtNombresAdmin.text.toString().trim()
        email = binding.EtEmailAdmin.text.toString().trim()
        password = binding.EtPasswordAdmin.text.toString().trim()
        r_password = binding.EtRPasswordAdmin.text.toString().trim()

        if(nombres.isEmpty()){
            binding.EtNombresAdmin.error = "Ingrese nombres"
            binding.EtNombresAdmin.requestFocus()
        }else if(email.isEmpty()){
            binding.EtEmailAdmin.error = "Ingresa email"
            binding.EtEmailAdmin.requestFocus()
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.EtEmailAdmin.error = "Email no es valido"
            binding.EtEmailAdmin.requestFocus()
        }else if(password.isEmpty()){
            binding.EtPasswordAdmin.error = "Ingrese la contraseña"
            binding.EtPasswordAdmin.requestFocus()
        }else if(password.length < 6){
            binding.EtPasswordAdmin.error = "La contraseña debe tener más de 6 caracteres"
            binding.EtPasswordAdmin.requestFocus()
        }else if(r_password.isEmpty()){
            binding.EtRPasswordAdmin.error = "Repita la contraseña"
            binding.EtRPasswordAdmin.requestFocus()
        }else if(password != r_password){
            binding.EtRPasswordAdmin.error = "Las contraseñas no coinciden"
            binding.EtRPasswordAdmin.requestFocus()
        }else{
            CrearCuentaAdmin(email, password)
        }
    }

    private fun CrearCuentaAdmin(email: String, password: String) {
        progressDialog.setMessage("Creando cuenta")
        progressDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                enviarEmailVerificacion() //Agregada
                AgregarInfoBD()
            }

            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "Ha fallado la creación de la cuenta debido a ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }

    //Agregada
    private fun enviarEmailVerificacion(){
        val user = firebaseAuth.currentUser!!
        user.sendEmailVerification().addOnCompleteListener(this){task->
            if(task.isSuccessful){

            }else{

            }
        }
    }


    private fun AgregarInfoBD() {
       progressDialog.setMessage("Guardando información...")
        val tiempo = System.currentTimeMillis()
        val uid = firebaseAuth.uid

        //Mandar los datos que se obtienen en el registro del administrador
        val datos_admin : HashMap<String, Any?> = HashMap()
        datos_admin["uid"] = uid
        datos_admin["nombres"] = nombres
        datos_admin["email"] = email
        datos_admin["rol"] = "admin"
        datos_admin["tiempo_registro"] = tiempo
        datos_admin["imagen"] = ""

        //Referencia a la base de datos de firebase
        val reference = FirebaseDatabase.getInstance().getReference("Usuarios")
        reference.child(uid!!)
            .setValue(datos_admin)
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "Cuenta creada", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "No se pudo guardar la información debido a ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}