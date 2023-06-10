package edu.unicauca.aplimovil.unicar.ui

import android.service.controls.ControlsProviderService
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import java.lang.ref.Reference

class OrderViewModel: ViewModel() {
    private val firebaseAuth: FirebaseAuth = Firebase.auth
    private val firebaseFirestore: FirebaseFirestore = Firebase.firestore

    fun registrarUsuario(nombre: String, idUsuario: Int, clave: String, correo: String, celular: String) {
        // Crear un nuevo documento para el usuario en Firestore
        val usuario = hashMapOf(
            "nombre" to nombre,
            "id_usuario" to idUsuario,
            "celular" to celular,
            "correo" to correo,
            "clave" to clave
        )
        firebaseFirestore.collection("Usuarios")
            .add(usuario)
            .addOnCompleteListener { registrationToFirestoreTask ->
                Log.d("Registro", "Registro completado: ${registrationToFirestoreTask.isSuccessful}")
                if (registrationToFirestoreTask.isSuccessful) {

                } else {
                }
            }
    }

    fun consultarCredenciales(correo: String, password: String) {
        //firebaseFirestore.collection("Usuarios").get()
        //EN CONSTRUCCIÓN

    }
}