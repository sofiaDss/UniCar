package edu.unicauca.aplimovil.unicar.ui

import android.service.controls.ControlsProviderService
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import edu.unicauca.aplimovil.unicar.UnicarScreen
import java.lang.ref.Reference

class OrderViewModel: ViewModel() {
    private val firebaseAuth: FirebaseAuth = Firebase.auth
    private val firebaseFirestore: FirebaseFirestore = Firebase.firestore

    private val auth: FirebaseAuth = Firebase.auth
    private val _loading =  MutableLiveData(false)

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

    fun iniciarSesion(correo: String, navController: NavHostController) {
        // Realizar una consulta a Firestore para obtener los datos del usuario basado en el correo electrónico
        firebaseFirestore.collection("Usuarios")
            .whereEqualTo("correo", correo)
            .whereEqualTo("rol", "conductor")
            .get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
                    // Obtener el documento del usuario
                    val documentSnapshot = querySnapshot.documents[0]
                    val clave = documentSnapshot.getString("clave")

                    if (clave != null) {
                        // Autenticar al usuario en Firebase Authentication utilizando el correo electrónico y la contraseña obtenidos de Firestore
                        Log.d("InicioSesion", "Correo: $correo") // Imprimir el valor de correo
                        Log.d("InicioSesion", "Clave: $clave") // Imprimir el valor de clave

                        firebaseAuth.signInWithEmailAndPassword(correo, clave)
                            .addOnCompleteListener { signInTask ->
                                if (signInTask.isSuccessful) {
                                    // Inicio de sesión exitoso
                                    Log.d("InicioSesion", "Inicio de sesión exitoso")
                                    navController.navigate(UnicarScreen.homeConductorScreen.name)
                                } else {
                                    // Error al iniciar sesión
                                    Log.e("InicioSesion", "Error al iniciar sesión: ${signInTask.exception}")
                                    // Aquí puedes manejar el error o mostrar un mensaje de error al usuario
                                }
                            }
                    } else {
                        Log.e("InicioSesion", "No se pudo obtener la contraseña del usuario")

                    }
                } else {
                    Log.e("InicioSesion", "No se encontró ningún usuario con el correo electrónico proporcionado")
                    // Poner codigo para que se muestre usuario no registrado
                }
            }
            .addOnFailureListener { exception ->
                Log.e("InicioSesion", "Error al obtener los datos del usuario: $exception")

            }
    }

    fun createUserWithEmailAndPassword(nombre: String, idUsuario: Int, clave: String, correo: String, celular: String, home: () -> Unit){
        if (_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(correo, clave)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        val userId = user?.uid
                        // Guardar datos adicionales en Firestore
                        val userData = hashMapOf(
                            "nombre" to nombre,
                            "id_usuario" to idUsuario,
                            "celular" to celular,
                            "rol" to "pasajero"
                        )

                        if (userId != null) {
                            val db = Firebase.firestore
                            db.collection("usuarios").document(userId)
                                .set(userData)
                                .addOnSuccessListener {
                                    home()
                                }
                                .addOnFailureListener { e ->
                                    Log.e("Registro", "Error al guardar los datos adicionales: ", e)
                                }
                        }
                    } else {
                        Log.d("Registro", "Registro completado: ${task.isSuccessful}")
                    }
                }
        }
    }
}