package edu.unicauca.aplimovil.unicar.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import edu.unicauca.aplimovil.unicar.R
import edu.unicauca.aplimovil.unicar.UnicarScreen

@Composable
fun registroScreen(navController : NavHostController,modifier: Modifier = Modifier,viewModel: OrderViewModel) {

    val confirmarClaveValue = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val nombreValue = remember { mutableStateOf(TextFieldValue())}
    val id_usuarioValue = remember { mutableStateOf(TextFieldValue())}
    val claveValue = remember { mutableStateOf(TextFieldValue())}
    val correoValue = remember { mutableStateOf(TextFieldValue())}
    val celularValue = remember { mutableStateOf(TextFieldValue())}
    val isSaved = remember { mutableStateOf(false) }
    val showError = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    var selectedOption by remember { mutableStateOf("Pasajero") }

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
                .height(180.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 16.dp))
                .background(color = colorResource(id = R.color.azul1))  ,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.unicar_sinfondo),
                contentDescription = "1",
                modifier = Modifier
                    .fillMaxSize()
                    .scale(0.8f)
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
            onClick = { navController.navigate(UnicarScreen.inicioSesionScreen.name) },
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
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(15.dp))
                        .focusRequester(focusRequester)
                        .background(colorResource(id = R.color.azul2)),
                    value = nombreValue.value,
                    onValueChange = { nombreValue.value = it },
                    label = { Text("Ingresa tu nombre") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Identificación",
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
                        .focusRequester(focusRequester)
                        .background(colorResource(id = R.color.azul2)),
                    value = id_usuarioValue.value,
                    onValueChange = { id_usuarioValue.value = it },
                    label = { Text("Ingresa tu identificación") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Correo Institucional",
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
                        .focusRequester(focusRequester)
                        .background(colorResource(id = R.color.azul2)),
                    value = correoValue.value,
                    onValueChange = { correoValue.value = it },
                    label = { Text("Ingresa tu correo institucional") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
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
                        .focusRequester(focusRequester)
                        .background(colorResource(id = R.color.azul2))
                        .focusRequester(focusRequester),
                    value = claveValue.value,
                    onValueChange = { claveValue.value = it },
                    label = { Text("Ingresa tu contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )

                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Verifica tu contraseña",
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
                        .focusRequester(focusRequester)
                        .background(colorResource(id = R.color.azul2)),
                    value = confirmarClaveValue.value,
                    onValueChange = { confirmarClaveValue.value = it },
                    label = { Text("Ingresa nuevamente tu contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )

                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Celular",
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
                    value = celularValue.value,
                    onValueChange = { celularValue.value = it },
                    label = { Text("Ingresa tu número de teléfono") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {focusManager.clearFocus()}
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier
                    .fillMaxSize()
                ) {
                    Text(
                        text = "Rol: ",
                        style = TextStyle(fontSize = 16.sp,
                            color = colorResource(id = R.color.azul1),
                            fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    val roles = listOf("pasajero")
                    var selectedRole by remember { mutableStateOf("pasajero") } // Opción "pasajero" seleccionada por defecto

                    Column (verticalArrangement = Arrangement.Center ) {
                        roles.forEach { role ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .selectable(
                                        selected = (selectedRole == role),
                                        onClick = { selectedRole = role }
                                    )
                                    .padding(horizontal = 16.dp)
                            ) {
                                RadioButton(
                                    selected = (selectedRole == role),
                                    onClick = { selectedRole = role }
                                )
                                Text(
                                    text = role,
                                    style = TextStyle(fontSize = 16.sp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            val password = claveValue.value.text
                            val confirmPassword = confirmarClaveValue.value.text
                            val passwordsMatch = verifyPasswordsMatch(password, confirmPassword)
                            val nombre = nombreValue.value.text
                            val idUsuario = id_usuarioValue.value.text.toIntOrNull()
                            val clave = claveValue.value.text
                            val correo = correoValue.value.text
                            val celular = celularValue.value.text

                            if (nombre.isNotEmpty() && idUsuario != null && clave.isNotEmpty() && confirmPassword.isNotEmpty() && correo.isNotEmpty() && celular.isNotEmpty()){
                                if(passwordsMatch){
                                    viewModel.createUserWithEmailAndPassword(nombre, idUsuario, clave, correo, celular){
                                        navController.navigate(UnicarScreen.inicioScreen.name)
                                    }
                                    Toast.makeText(context, "¡Registro exitoso!", Toast.LENGTH_SHORT).show()
                                    nombreValue.value = TextFieldValue()
                                    id_usuarioValue.value = TextFieldValue()
                                    claveValue.value = TextFieldValue()
                                    confirmarClaveValue.value=TextFieldValue()
                                    correoValue.value = TextFieldValue()
                                    celularValue.value = TextFieldValue()
                                } else{
                                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                // Manejar el caso de que alguna caja de texto esté vacía
                                Toast.makeText(context, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.azul1),
                        )
                    ) {
                        Text(
                            text = "REGISTRARSE",
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

private fun verifyPasswordsMatch(password: String, confirmPassword: String): Boolean {
    return password == confirmPassword
}

@Preview
@Composable
fun RegistroScreenPreview(){
   // registroScreen(   )
}