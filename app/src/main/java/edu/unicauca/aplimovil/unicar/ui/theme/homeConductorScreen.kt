package edu.unicauca.aplimovil.unicar.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.unicauca.aplimovil.unicar.R

@Composable
fun homeConductorScreen() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .background(colorResource(id = R.color.white))) {
        Row( modifier = Modifier
            .clip(shape = RoundedCornerShape(bottomStart = 16.dp))
            .background(color = colorResource(id = R.color.darkBlue))
            .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.fillMaxWidth()) {
                    val imagen2 = painterResource(id = R.drawable.unicar_sinfondo)
                    Image(
                        painter = imagen2,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Text(text = "inicio")
                    Text(text = "cerrar sesión")
                    Text(text = "pregunta")
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "UserName")
                    Text(text = "Conductor")
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()) {
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier
                .padding(10.dp)
                .height(IntrinsicSize.Min)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = colorResource(id = R.color.ligthBlue))) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Nuevo recorrido",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue),
                        modifier = Modifier.padding(10.dp)

                    )

                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    val imagen31 = painterResource(id = R.drawable.placeholder)
                    Image(
                        painter = imagen31,
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
                    val imagen21 = painterResource(id = R.drawable.place)
                    Image(
                        painter = imagen21,
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .weight(0.10f)
                            .size(25.dp)
                        //contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Destino",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue),
                        modifier = Modifier.weight(0.40f)
                    )
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = "",
                        onValueChange = {
                            // Acción al cambiar el valor del campo de texto
                        },
                        label = { Text("Ingresa nuevamente tu contraseña") },
                        modifier = Modifier.padding(end = 8.dp) // Espacio entre el campo de texto y la imagen
                    )

                    Image(
                        painter = painterResource(id = R.drawable.flechas),
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)

                        //contentScale = ContentScale.Crop
                    )
                    Text(text = "destinoformulario")
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val imagen11 = painterResource(id = R.drawable.calendar)
                    Image(
                        painter = imagen11,
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)
                        //contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Fecha salida:",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue)
                    )
                    Text(text = "Formulario")
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    val imagen12 = painterResource(id = R.drawable.calendar2)
                    Image(
                        painter = imagen12,
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)
                        //contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Fecha llegada:",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue)
                    )
                    Text(text = "Formulario")
                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    val imagen11 = painterResource(id = R.drawable.people)
                    Image(
                        painter = imagen11,
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)
                        //contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Cupos:",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.darkBlue)
                    )
                    Text(text = "Formulario")
                }
                Row(modifier = Modifier.fillMaxWidth(),
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
                .background(color = colorResource(id = R.color.ligthBlue))) {
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
            Row(modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(topStart = 32.dp))
                .background(color = colorResource(id = R.color.darkBlue))
                .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(text = "Menú final")
            }
        }
    }
}





@Preview
@Composable
fun homeConductorScreenPreview(){
    homeConductorScreen(

        //quantityOptions = DataSource.quantityOptions,
        //modifier = Modifier.fillMaxSize().padding(dimensionResource(R.dimen.padding_medium))
    )
}