package edu.unicauca.aplimovil.unicar.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
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
                    // Registro exitoso
                } else {
                    // Manejar error al guardar datos en Firestore
                }
            }
    }
}