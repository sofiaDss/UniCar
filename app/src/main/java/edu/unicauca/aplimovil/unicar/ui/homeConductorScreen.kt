package edu.unicauca.aplimovil.unicar.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import edu.unicauca.aplimovil.unicar.R
import edu.unicauca.aplimovil.unicar.UnicarScreen
import java.util.*

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
//fun homeConductorScreen() {
fun homeConductorScreen(
    navController : NavHostController,
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel,
    orderUiState: OrderUiState
) {
    val origenValue = remember { mutableStateOf(TextFieldValue()) }
    val destinoValue = remember { mutableStateOf(TextFieldValue()) }
    val fechaValue = remember { mutableStateOf("--") }
    val horaSalidaValue = remember { mutableStateOf("--") }
    val horaLlegadaValue = remember { mutableStateOf("--") }
    val auxHora = remember { mutableStateOf("--") }
    val cuposValue = remember { mutableStateOf(TextFieldValue()) }
    val auxValue = remember { mutableStateOf(TextFieldValue())}

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val year: Int = 2000
    val month: Int = 1
    val day: Int = 1
    calendar.time= Date()

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            fechaValue.value= String.format("%02d/%02d/%02d",dayOfMonth,month+1,year)
        }, year, month,day
    )
    datePicker.datePicker.minDate = calendar.timeInMillis

    val hour: Int = 0
    val minute: Int = 0

    val timePicker1 = TimePickerDialog(
        context,
        { _, hour: Int, minute: Int ->
            horaSalidaValue.value = String.format("%02d:%02d %s", if (hour>12) hour-12 else hour,minute,if (hour<12) "am" else "pm")
        }, hour, minute, false
    )
    val timePicker2 = TimePickerDialog(
        context,
        { _, hour: Int, minute: Int ->
            horaLlegadaValue.value = String.format("%02d:%02d %s", if (hour>12) hour-12 else hour,minute,if (hour<12) "am" else "pm")
        }, hour, minute, false
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ){
        Row(
            modifier = Modifier
                .fillMaxHeight(0.266f)
                .clip(shape = RoundedCornerShape(bottomEnd = 60.dp))
                .background(color = colorResource(id = R.color.darkBlue)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp))
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.unicar_sinfondo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                    IconButton(
                        onClick = {
                            navController.navigate(UnicarScreen.construccionScreen.name)
                        }
                    ) {
                        Image(painter = painterResource(id = R.drawable.usuario), contentDescription =null )
                    }
                    IconButton(
                        onClick = {
                            navController.navigate(UnicarScreen.construccionScreen.name)
                        }
                    ) {
                        Image(painter = painterResource(id = R.drawable.botoninformacion), contentDescription =null )
                    }
                    IconButton(
                        onClick = {
                            viewModel.resetInfo()
                            navController.navigate(UnicarScreen.inicioScreen.name)
                        }
                    ) {
                        Image(painter = painterResource(id = R.drawable.cerrarsesion), contentDescription =null )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = viewModel.uiState.value.nameUser,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white),
                        modifier = Modifier.padding(10.dp).weight(0.5f)
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                    Button(
                        onClick = { /* cambiar de role si cuenta con ambos registrados */ },
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(0.4f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.white)
                        ),
                        shape = RoundedCornerShape(30)
                    ) {
                        Text(
                            text = "Conductor",
                            color = colorResource(id = R.color.darkBlue),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .verticalScroll(scrollState)
        )
        {
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = colorResource(id = R.color.ligthBlue))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Nuevo recorrido",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue),
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.placeholder),
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(25.dp)
                            .weight(0.10f)
                    )
                    Text(
                        text = "Origen",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue),
                        modifier = Modifier.weight(0.40f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.place),
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .weight(0.10f)
                            .size(25.dp)
                    )
                    Text(
                        text = "Destino",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue),
                        modifier = Modifier.weight(0.22f)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = origenValue.value,
                        onValueChange = { origenValue.value = it },
                        label = { Text("Origen") },
                        singleLine = true,
                        modifier = Modifier
                            .weight(0.4f)
                            .height(60.dp)
                            .padding(start = 8.dp), // Espacio entre el campo de texto y la imagen
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Right) }
                        )
                    )
                    IconButton(
                        modifier = Modifier.weight(0.2f),
                        onClick = {
                            auxValue.value= origenValue.value
                            origenValue.value=destinoValue.value
                            destinoValue.value=auxValue.value
                        }
                    ) {
                        Image(painter = painterResource(id = R.drawable.flechas), contentDescription =null )
                    }
                    TextField(
                        value = destinoValue.value,
                        onValueChange = { destinoValue.value = it },
                        label = { Text("Destino") },
                        modifier = Modifier
                            .weight(0.4f)
                            .height(60.dp)
                            .padding(end = 8.dp), // Espacio entre el campo de texto y la imagen
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = Modifier
                            .padding(horizontal =  16.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.ligthBlue)
                        ),
                        onClick = {
                            datePicker.show()
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.calendario),
                            contentDescription = null,
                            modifier=Modifier.padding(end = 16.dp)
                        )
                        Text(text = "Fecha:",fontWeight = FontWeight.Bold, color = colorResource(id = R.color.darkBlue))
                    }
                    Text(
                        text = fechaValue.value,
                        color = colorResource(id = R.color.black)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.ligthBlue)
                        ),
                        onClick = {
                            timePicker1.show()
                            horaSalidaValue.value=auxHora.value
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.reloj2),
                            contentDescription = null,
                            modifier=Modifier.padding(end = 16.dp)
                        )
                        Text(text = "Hora salida:",fontWeight = FontWeight.Bold, color = colorResource(id = R.color.darkBlue))
                    }
                    Text(
                        text = horaSalidaValue.value,
                        color = colorResource(id = R.color.black)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.ligthBlue)
                        ),
                        onClick = {
                            timePicker2.show()
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.reloj1),
                            contentDescription = null,
                            modifier=Modifier.padding(end = 16.dp)
                        )
                        Text(text = "Hora llegada:",fontWeight = FontWeight.Bold, color = colorResource(id = R.color.darkBlue))
                    }
                    Text(
                        text = horaLlegadaValue.value,
                        color = colorResource(id = R.color.black)
                    )
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(25.dp)
                    )
                    Text(
                        text = "Cupos:",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue)
                    )
                    TextField(
                        value = cuposValue.value,
                        onValueChange = {
                            if (it.text.length <= 1) cuposValue.value = it
                            else Toast.makeText(context, "Cupos supera el límite", Toast.LENGTH_SHORT).show()
                        },
                        label = { Text("Cupos") },
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(0.2f)
                            .height(60.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {focusManager.clearFocus()}
                        )
                    )
                }
                Spacer(modifier= Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            val origen = origenValue.value.text
                            val destino = destinoValue.value.text
                            val fecha = fechaValue.value
                            val horaSalida = horaSalidaValue.value
                            val horaLlegada = horaLlegadaValue.value
                            val cupos = cuposValue.value.text.toIntOrNull()

                            if (origen.isNotEmpty() && destino.isNotEmpty() && !fecha.equals("--") && !horaSalida.equals("--") && !horaLlegada.equals("--") && cupos != null){
                                    viewModel.registrarRuta(origen, destino, fecha, horaSalida, horaLlegada, cupos,context)
                                    origenValue.value = TextFieldValue()
                                    destinoValue.value = TextFieldValue()
                                    fechaValue.value = "--"
                                    horaSalidaValue.value = "--"
                                    horaLlegadaValue.value = "--"
                                    cuposValue.value = TextFieldValue()
                                    navController.navigate(UnicarScreen.homeConductorScreen.name)

                            } else {
                                // Manejar el caso de que alguna caja de texto esté vacía
                                Toast.makeText(context, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .padding(end = 8.dp, bottom = 16.dp)
                            .height(48.dp)
                            .widthIn(120.dp),
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.darkBlue)
                        )
                    ) {
                        Text(
                            text = "Agregar recorrido",
                            color = colorResource(id = R.color.white),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = colorResource(id = R.color.ligthBlue))
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Tus recorridos",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue),
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(colorResource(id = R.color.white))) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.place),
                            contentDescription = null,
                            alignment = Alignment.BottomStart,
                            modifier = Modifier
                                .padding(16.dp)
                                .size(25.dp)
                            //contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Destino: ",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.darkBlue)
                        )
                        Text(text = orderUiState.destino)
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.calendar),
                            contentDescription = null,
                            alignment = Alignment.BottomStart,
                            modifier = Modifier
                                .padding(16.dp)
                                .size(25.dp)
                        )
                        Text(
                            text = "Fecha - Hora: ",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.darkBlue)
                        )
                        Text(text = orderUiState.fecha + " - "+ orderUiState.horaSalida)
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.people),
                            contentDescription = null,
                            alignment = Alignment.BottomStart,
                            modifier = Modifier
                                .padding(16.dp)
                                .size(25.dp)
                        )
                        Text(
                            text = "Cupos reservados: ",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.darkBlue)
                        )
                        Text(text =  orderUiState.cupos)
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .clip(shape = RoundedCornerShape(topStart = 30.dp))
                .background(color = colorResource(id = R.color.darkBlue)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .weight(0.2f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.darkBlue)
                ),
                onClick = {
                    navController.navigate(UnicarScreen.homeConductorScreen.name)
                }
            ) {
                Image(painter = painterResource(id = R.drawable.casa), contentDescription = null)
                Text(text = "Home", color = colorResource(id = R.color.white))
            }
            Button(
                modifier = Modifier
                    .weight(0.2f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.darkBlue)
                ),
                onClick = {
                    navController.navigate(UnicarScreen.construccionScreen.name)
                }
            ) {
                Image(painter = painterResource(id = R.drawable.coche), contentDescription = null)
                Text(text = "Vehículo", color = colorResource(id = R.color.white))
            }
            Button(
                modifier = Modifier
                    .weight(0.2f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.darkBlue)
                ),
                onClick = {
                    navController.navigate(UnicarScreen.construccionScreen.name)
                }
            ) {
                Image(painter = painterResource(id = R.drawable.mapa), contentDescription = null)
                Text(text = "Ubicación", color = colorResource(id = R.color.white))
            }
            Button(
                modifier = Modifier
                    .weight(0.2f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.darkBlue)
                ),
                onClick = {
                    navController.navigate(UnicarScreen.construccionScreen.name)
                }
            ) {
                Image(painter = painterResource(id = R.drawable.historia), contentDescription = null)
                Text(text = "Historial", color = colorResource(id = R.color.white))
            }
        }
    }
}





@Preview
@Composable
fun homeConductorScreenPreview(){
    //homeConductorScreen()
}