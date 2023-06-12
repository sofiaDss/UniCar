package edu.unicauca.aplimovil.unicar.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import edu.unicauca.aplimovil.unicar.UnicarScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel: ViewModel() {
    private val firebaseAuth: FirebaseAuth = Firebase.auth
    private val firebaseFirestore: FirebaseFirestore = Firebase.firestore

    private val auth: FirebaseAuth = Firebase.auth
    private val _loading =  MutableLiveData(false)
    //private val firestore = Firebase.firestore

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

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

    fun iniciarSesion(correo: String, navController: NavHostController, contexto: Context) {
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
                                    consultarUltimaRuta()
                                    navController.navigate(UnicarScreen.homeConductorScreen.name)
                                } else {
                                    // Error al iniciar sesión
                                    Log.e("InicioSesion", "Error al iniciar sesión: ${signInTask.exception}")
                                    Toast.makeText(contexto, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        Log.e("InicioSesion", "No se pudo obtener la contraseña del usuario")
                        Toast.makeText(contexto, "Error en credenciales", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("InicioSesion", "No se encontró ningún usuario con el correo electrónico proporcionado")
                    Toast.makeText(contexto, "¿Usuario NO registrado?", Toast.LENGTH_SHORT).show()
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
                            "correo" to correo,
                            "clave" to clave,
                            "rol" to "pasajero"
                        )

                        if (userId != null) {
                            val db = Firebase.firestore
                            db.collection("Usuarios").document(userId)
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

    fun setCorreo(correo: String) {
        _uiState.update { currentState ->
            currentState.copy(
                emailUser = correo
            )
        }
    }

    fun setIdNombre(id: Int, nombre: String) {
        _uiState.update { currentState ->
            currentState.copy(
                idUser = id,
                nameUser = nombre
            )
        }
    }

    fun setInfoRuta(idRuta:Int, destino: String, fecha: String, hora: String, cupos: String) {
        _uiState.update { currentState ->
            currentState.copy(
                idRuta = idRuta,
                destino = destino,
                fecha = fecha,
                horaSalida = hora,
                cupos = cupos
            )
        }
    }

    fun resetInfo() {
        _uiState.value = OrderUiState()
    }

    fun consultarUsuario(){
        firebaseFirestore.collection("Usuarios")
            .whereEqualTo("correo", uiState.value.emailUser)
            .get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
                    val documentSnapshot = querySnapshot.documents[0]
                    setIdNombre(
                        documentSnapshot.get("id_usuario").toString().toInt(),
                        documentSnapshot.getString("nombre").toString()
                    )
                } else {
                    Log.e("InfoHomeUsuario", "No se encontró ningún registro del usuario búscado")
                }
            }
            .addOnFailureListener { exception ->
                Log.e("HomeUsuario", "Error al obtener los datos del usuario: $exception")
            }
    }
    fun consultarUltimaRuta(){
        firebaseFirestore.collection("Rutas")
            //.whereEqualTo("id_usuario", uiState.value.idUser)
            .orderBy("id_ruta",Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
                    var documentSnapshot=querySnapshot.documents[0]
                    var bandera:Boolean=false
                    for (document in querySnapshot.documents){
                        if (document.get("id_usuario").toString().toInt()==uiState.value.idUser){
                            documentSnapshot=document
                            bandera=true
                            break
                        }
                    }
                    if(bandera==true) {
                        setInfoRuta(
                            documentSnapshot.get("id_ruta").toString().toInt(),
                            documentSnapshot.getString("destino").toString(),
                            documentSnapshot.getString("fecha").toString(),
                            documentSnapshot.getString("hora_salida").toString(),
                            documentSnapshot.get("num_cupos").toString()
                        )
                    }
                } else {
                    setInfoRuta(0,"","","","")
                    Log.e("InfoRuta", "No se encontró ninguna ruta registrada para el usuario")
                }
            }
            .addOnFailureListener { exception ->
                Log.e("HomeUsuarioRuta", "Error al obtener los datos de la ruta: $exception")
            }
    }

    fun registrarRuta(origen: String, destino: String, fecha: String, horaSalida: String, horaLlegada: String, cupos: Int, contexto: Context){

        val ruta = hashMapOf(
            "origen" to origen,
            "destino" to destino,
            "id_usuario" to uiState.value.idUser,
            "id_ruta" to uiState.value.idRuta+1,
            "fecha" to fecha,
            "hora_salida" to horaSalida,
            "hora_llegada" to horaLlegada,
            "num_cupos" to cupos
        )
        firebaseFirestore.collection("Rutas")
            .add(ruta)
            .addOnCompleteListener { registrationToFirestoreTask ->
                Log.d("Registro", "Registro completado: ${registrationToFirestoreTask.isSuccessful}")
                if (registrationToFirestoreTask.isSuccessful) {
                    consultarUltimaRuta()
                    Toast.makeText(contexto, "¡Registro de Ruta exitoso!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(contexto, "¡Ruta NO registrada!", Toast.LENGTH_SHORT).show()
                }
            }
    }

}