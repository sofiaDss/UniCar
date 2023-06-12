package edu.unicauca.aplimovil.unicar

import android.graphics.Paint.Align
import android.os.Bundle
import android.service.controls.ControlsProviderService
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.aplimovil.unicar.ui.theme.UniCarTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import edu.unicauca.aplimovil.unicar.ui.construccionScreen
import edu.unicauca.aplimovil.unicar.ui.homeConductorScreen


class MainActivity : ComponentActivity() {
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniCarTheme {
                UnicarApp()
                //mostrarInterfaz()
            }
        }
    }

    @Composable
    private fun mostrarInterfaz() {
        // Crea una variable del estado para almacenar el texto del documento
        val textoDocumento = remember { mutableStateOf("") }

        obtenerDatos { document ->
            if (document != null) {
                val texto = document.getString("destino") // Reemplaza "nombre" con el nombre del campo de texto que deseas mostrar
                textoDocumento.value = texto ?: ""
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = textoDocumento.value,
            )
        }
    }

    private fun obtenerDatos(onSuccess: (document: DocumentSnapshot?) -> Unit) {
        val docRef = db.collection("Rutas").document("b9uoxStmzVmF5oGpT0Qw")
        docRef.get()
            .addOnSuccessListener { document ->
                onSuccess(document)
            }
            .addOnFailureListener { exception ->
                Log.d(ControlsProviderService.TAG, "get failed with ", exception)
                onSuccess(null)
            }
    }
}





