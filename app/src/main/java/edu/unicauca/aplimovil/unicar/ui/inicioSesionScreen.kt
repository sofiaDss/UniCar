package edu.unicauca.aplimovil.unicar.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import edu.unicauca.aplimovil.unicar.R
import edu.unicauca.aplimovil.unicar.UnicarScreen


@Composable
fun inicioSesionScreen(navController : NavHostController,viewModel: OrderViewModel){

    val correoValue = remember { mutableStateOf(TextFieldValue()) }
    val claveValue = remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current

    val focusManager = LocalFocusManager.current

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
                        .padding(top = 40.dp, bottom = 30.dp),
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
                                    .height(60.dp)
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(15.dp))
                                    .background(colorResource(id = R.color.azul2)),
                                value = correoValue.value,
                                onValueChange = { correoValue.value = it },
                                label = { Text("Ingresa tu correo institucional")},
                                singleLine = true,
                                colors = TextFieldDefaults.textFieldColors(
                                    cursorColor =  colorResource(id = R.color.azul1),
                                    focusedIndicatorColor = colorResource(id = R.color.azul1)
                                ),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                                )
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
                                    .height(60.dp)
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(15.dp))
                                    .background(colorResource(id = R.color.azul2)),
                                colors = TextFieldDefaults.textFieldColors(
                                    cursorColor =  colorResource(id = R.color.azul1),
                                    focusedIndicatorColor = colorResource(id = R.color.azul1)
                                ),
                                value = claveValue.value,
                                onValueChange = { claveValue.value = it },
                                label = { Text("Ingresa tu contraseña") },
                                singleLine = true,
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    imeAction = ImeAction.Done
                                ),
                                keyboardActions = KeyboardActions(
                                    onDone = {focusManager.clearFocus()}
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Column(
                                modifier = Modifier
                                    .height(60.dp)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                ClickableText(
                                    text = AnnotatedString("¿Olvidaste la contraseña?"),
                                    onClick = {navController.navigate(UnicarScreen.construccionScreen.name)},
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color.Gray,
                                        textDecoration = TextDecoration.Underline
                                    ),
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {
                                        val correo = correoValue.value.text
                                        val clave = claveValue.value.text
                                        if (correo.isNotBlank() && clave.isNotBlank()) {
                                            viewModel.iniciarSesion(correo, navController)
                                        } else {
                                            // Campos vacíos, mostrar mensaje de error o realizar alguna acción
                                            Toast.makeText(context, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                                        }
                                    },
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
    //inicioSesionScreen()
}