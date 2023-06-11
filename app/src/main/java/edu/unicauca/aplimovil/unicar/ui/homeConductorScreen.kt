package edu.unicauca.aplimovil.unicar.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.util.Log
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
import androidx.compose.runtime.getValue
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
//fun homeConductorScreen() {
fun homeConductorScreen(navController : NavHostController,modifier: Modifier = Modifier,viewModel: OrderViewModel) {
    val origenValue = remember { mutableStateOf(TextFieldValue()) }
    val destinoValue = remember { mutableStateOf(TextFieldValue()) }
    val fechaValue = remember { mutableStateOf("--") }
    val horaSalida = remember { mutableStateOf("--") }
    val horaLlegada = remember { mutableStateOf("--") }
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
            fechaValue.value= "$dayOfMonth/${month+1}/$year"
        }, year, month,day
    )
    datePicker.datePicker.minDate = calendar.timeInMillis

    val hour: Int = 0
    val minute: Int = 0

    val timePicker1 = TimePickerDialog(
        context,
        { _, hour: Int, minute: Int ->
            horaSalida.value = "$hour:$minute"
        }, hour, minute, false
    )
    val timePicker2 = TimePickerDialog(
        context,
        { _, hour: Int, minute: Int ->
            horaLlegada.value = "$hour:$minute"
        }, hour, minute, false
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ){
        Row(
            modifier = Modifier
                .fillMaxHeight(0.23f)
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
                        onClick = {Log.d("usuario", "información del Usuario")}
                    ) {
                        Image(painter = painterResource(id = R.drawable.usuario), contentDescription =null )
                    }
                    IconButton(
                        onClick = {Log.d("información", "información de la app")}
                    ) {
                        Image(painter = painterResource(id = R.drawable.botoninformacion), contentDescription =null )
                    }
                    IconButton(
                        onClick = {Log.d("sesion", "cerrar sesión")}
                    ) {
                        Image(painter = painterResource(id = R.drawable.cerrarsesion), contentDescription =null )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "User Name",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white),
                        modifier = Modifier.padding(10.dp)
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                    Button(
                        onClick = {Log.d("tipo usuario", "cambiar de role si cuenta con ambos registrados") },
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
                            horaSalida.value=auxHora.value
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
                        text = horaSalida.value,
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
                        text = horaLlegada.value,
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
                        onClick = { /* Lógica del botón de registro */ },
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
                            text = "Destino:",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.darkBlue)
                        )
                        Text(text = "Texto de database")
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
                            //contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Fecha inicio:",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.darkBlue)
                        )
                        Text(text = "Texto de database")
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
                            //contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Cupos reservados:",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.darkBlue)
                        )
                        Text(text = "Texto de database")
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
                onClick = {/*direcciona a interfaz home conductor*/}
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
                onClick = { /*direcciona al vehículo del conductor*/ }
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
                onClick = { /*direcciona a ubicaciones registradas*/ }
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
                onClick = { /*direcciona a ubicaciones registradas*/ }
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
    /*homeConductorScreen(

        //quantityOptions = DataSource.quantityOptions,
        //modifier = Modifier.fillMaxSize().padding(dimensionResource(R.dimen.padding_medium))
    )*/
}