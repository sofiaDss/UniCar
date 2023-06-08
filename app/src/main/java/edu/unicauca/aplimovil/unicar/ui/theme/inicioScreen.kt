package edu.unicauca.aplimovil.unicar.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.unicauca.aplimovil.unicar.R


@Composable
fun MainScreen() {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)) {
            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp))
                    .background(color = colorResource(id = R.color.darkBlue))
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                /*val imagen = painterResource(id = R.drawable.fondocurvo)
                Image(
                    painter = imagen,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )*/
                Column(modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {
                        val imagen1 = painterResource(id = R.drawable.unicar_sinfondo)
                        Image(
                            painter = imagen1,
                            contentDescription = null,
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(90.dp)
                                .fillMaxWidth()
                                .align(Alignment.Top)
                        )
                        Text(
                            text = "¡Bienvenid@!",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .fillMaxWidth(),
                            color = Color.White,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ///////

                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .height(48.dp)
                                .widthIn(120.dp),
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text(
                                text = "Registrarse",
                                color = colorResource(id = R.color.darkBlue),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        /////////
                        Button(
                            onClick = { /* Lógica del botón de registro */ },
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .height(48.dp)
                                .widthIn(120.dp),
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text(
                                text = "Iniciar sesión",
                                color = colorResource(id = R.color.darkBlue),
                                fontWeight = FontWeight.Bold
                            )
                        }
                        /////////////////
                    }
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .padding(16.dp)
                .verticalScroll(scrollState)
            ) {
                Column(modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = colorResource(id = R.color.ligthBlue))) {
                    //////////
                    val imagen2 = painterResource(id = R.drawable.logounicar_let_sinfondo)
                    Image(
                        painter = imagen2,
                        contentDescription = null,
                        alignment = Alignment.BottomStart,
                        //modifier = Modifier.size(32.dp),
                        //contentScale = ContentScale.Crop
                    )
                    /////////
                    Text(
                        text = stringResource(id = R.string.quienes_somos),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )
                    /////////
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = colorResource(id = R.color.ligthBlue))) {
                    //////////
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .wrapContentSize()
                            .height(IntrinsicSize.Min)) {
                        //////////////
                        val imagen3 = painterResource(id = R.drawable.cupon)
                        Image(
                            painter = imagen3,
                            contentDescription = null,
                            alignment = Alignment.BottomStart,
                            modifier = Modifier
                                .padding(16.dp)
                                .size(64.dp)
                            //contentScale = ContentScale.Crop
                        )
                        //////////////
                        Text(
                            text = "Pasajero",
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                                .fillMaxWidth(),
                            color = colorResource(id = R.color.darkBlue),
                            fontSize = 34.sp,
                            fontWeight = FontWeight.Bold
                        )
                        //////////////
                    }
                    /////////
                    Text(
                        text = stringResource(id = R.string.descripcion_pasajero),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        textAlign = TextAlign.Justify

                    )
                    /////////
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = colorResource(id = R.color.ligthBlue))) {
                    //////////
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.height(IntrinsicSize.Min)) {
                        //////////////
                        val imagen4 = painterResource(id = R.drawable.volante_de_coche)
                        Image(
                            painter = imagen4,
                            contentDescription = null,
                            alignment = Alignment.BottomStart,
                            modifier = Modifier
                                .padding(16.dp)
                                .size(64.dp)
                            //modifier = Modifier.size(32.dp),
                            //contentScale = ContentScale.Crop
                        )
                        //////////////
                        Text(
                            text = "Conductor",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .fillMaxWidth(),
                            color = colorResource(id = R.color.darkBlue),
                            fontSize = 34.sp,
                            fontWeight = FontWeight.Bold
                        )
                        //////////////
                    }
                    /////////
                    Text(
                        text = stringResource(id = R.string.descripcion_conductor),
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Justify
                    )
                    /////////
                }
            }

            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 16.dp))
                    .background(color = colorResource(id = R.color.darkBlue))
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Términos y condiciones",
                    modifier = Modifier.weight(1f),
                    color = colorResource(id = R.color.white)
                )
                val imagen5 = painterResource(id = R.drawable.facebook)
                Image(
                    painter = imagen5,
                    contentDescription = null,
                    alignment = Alignment.BottomStart,
                    modifier = Modifier.padding(top=16.dp, bottom = 16.dp, start = 16.dp,end = 16.dp)
                    //modifier = Modifier.size(32.dp),
                    //contentScale = ContentScale.Crop
                )
                val imagen6 = painterResource(id = R.drawable.correo)
                Image(
                    painter = imagen6,
                    contentDescription = null,
                    alignment = Alignment.BottomStart,
                    modifier = Modifier.padding(top=16.dp, bottom = 16.dp, start = 5.dp,end = 5.dp)
                    //modifier = Modifier.size(32.dp),
                    //contentScale = ContentScale.Crop
                )
                val imagen7 = painterResource(id = R.drawable.instagram)
                Image(
                    painter = imagen7,
                    contentDescription = null,
                    alignment = Alignment.BottomStart,
                    modifier = Modifier.padding(top=16.dp, bottom = 16.dp, start = 16.dp,end = 16.dp)
                    //modifier = Modifier.size(32.dp),
                    //contentScale = ContentScale.Crop
                )
                Text(
                    text = "Privacidad",
                    modifier = Modifier.weight(1f),
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen(

        //quantityOptions = DataSource.quantityOptions,
        //modifier = Modifier.fillMaxSize().padding(dimensionResource(R.dimen.padding_medium))
    )
}