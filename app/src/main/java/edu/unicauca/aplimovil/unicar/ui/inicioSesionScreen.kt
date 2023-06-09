package edu.unicauca.aplimovil.unicar.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
fun inicioSesionScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.azul1)),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.azul1)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.unicar_sinfondo),
                    contentDescription = "logo UniCar",
                    modifier = Modifier.height(200.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(topStart = 80.dp))
                    .background(color = colorResource(id = R.color.white)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp,bottom = 30.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Inicio de Sesión",
                        style = TextStyle(
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.azul1)
                        ),
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Text(
                        text = "Inicia sesión para continuar",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(top = 8.dp)
                    )
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
                            Text(text = "Correo institucional",
                                style = TextStyle(fontSize = 16.sp,
                                    color = colorResource(id = R.color.azul1),
                                    fontWeight = FontWeight.Bold)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            TextField(
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(15.dp))
                                    .background(colorResource(id = R.color.azul2)),
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = colorResource(id = R.color.azul1),
                                    cursorColor =  colorResource(id = R.color.azul1),
                                ),
                                value = "", // Valor inicial del campo de texto
                                onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                                label = { Text("Ingresa tu correo institucional") }
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            Text(text = "Contraseña",
                                style = TextStyle(fontSize = 16.sp,
                                    color = colorResource(id = R.color.azul1),
                                    fontWeight = FontWeight.Bold)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            TextField(
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(15.dp))
                                    .background(colorResource(id = R.color.azul2)),
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = colorResource(id = R.color.azul1),
                                    cursorColor =  colorResource(id = R.color.azul1),
                                ),
                                value = "", // Valor inicial del campo de texto
                                onValueChange = { /* Acción al cambiar el valor del campo de texto */ },
                                label = { Text("Ingresa tu contraseña") }
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            Column(
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "¿Olvidaste la contraseña?",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color.Gray
                                    ),
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))
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
                                    Text(text = "INICIAR SESIÓN",
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun inicioSesionScreenPreview(){
    inicioSesionScreen()
}