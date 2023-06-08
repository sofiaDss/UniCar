package edu.unicauca.aplimovil.unicar.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.unicauca.aplimovil.unicar.R

@Composable
fun cuadrante_uno(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier

                .fillMaxWidth()
                .height(100.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 16.dp))
                .background(color = colorResource(id = R.color.azul1))  ,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.unicar_sinfondo),
                contentDescription = "1",
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = "Registro",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.azul1)
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "¿Ya tienes una cuenta?",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = { /* Acción al hacer clic en el botón de inicio de sesión */ },
            modifier = Modifier
                //.padding(top = 16.dp)
                .fillMaxWidth()
                .height(48.dp),
            // shape = RoundedCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,

                )
        ) {
            Text(
                text = "Inicia Sesión",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(text = "Nombre",
                    style = TextStyle(fontSize = 16.sp,
                        color = colorResource(id = R.color.azul1),
                        fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(5.dp))

                TextField(
                    modifier = Modifier.height(50.dp).fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(colorResource(id = R.color.azul2)),
                    value = "", // Valor inicial del campo de texto
                    onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                    label = { Text("Ingresa tu nombre") }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Identificación",
                    style = TextStyle(fontSize = 16.sp,
                        color = colorResource(id = R.color.azul1),
                        fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    modifier = Modifier.height(50.dp).fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(colorResource(id = R.color.azul2)),
                    value = "", // Valor inicial del campo de texto
                    onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                    label = { Text("Ingresa tu identificación") }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Correo Institucional",
                    style = TextStyle(fontSize = 16.sp,
                        color = colorResource(id = R.color.azul1),
                        fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    modifier = Modifier.height(50.dp).fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(colorResource(id = R.color.azul2)),
                    value = "", // Valor inicial del campo de texto
                    onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                    label = { Text("Ingresa tu correo institucional") }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Contraseña",
                    style = TextStyle(fontSize = 16.sp,
                        color = colorResource(id = R.color.azul1),
                        fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    modifier = Modifier.height(50.dp).fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(colorResource(id = R.color.azul2)),
                    value = "", // Valor inicial del campo de texto
                    onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                    label = { Text("Ingresa tu contraseña") }

                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Verifica tu contraseña",
                    style = TextStyle(fontSize = 16.sp,
                        color = colorResource(id = R.color.azul1),
                        fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    modifier = Modifier.height(50.dp).fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(colorResource(id = R.color.azul2)),
                    value = "", // Valor inicial del campo de texto
                    onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                    label = { Text("Ingresa nuevamente tu contraseña") }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Celular",
                    style = TextStyle(fontSize = 16.sp,
                        color = colorResource(id = R.color.azul1),
                        fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    modifier = Modifier.height(50.dp).fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(colorResource(id = R.color.azul2)),
                    value = "", // Valor inicial del campo de texto
                    onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                    label = { Text("Ingresa tu número de teléfono") }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { /* Acción al hacer clic en el botón de enviar formulario */ },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.azul1),

                            )
                    ) {
                        Text(text = "REGISTRARSE",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold)
                        )

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RegistroScreenPreview(){
    cuadrante_uno(


    )
}