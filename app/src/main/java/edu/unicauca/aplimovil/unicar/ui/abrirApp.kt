package edu.unicauca.aplimovil.unicar.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.unicauca.aplimovil.unicar.R
import edu.unicauca.aplimovil.unicar.UnicarScreen
import kotlinx.coroutines.delay

@Composable
fun abrirApp(
    navController : NavHostController
){
    var iniciaanim by remember {mutableStateOf(false)}
    val alphaAnim= animateFloatAsState(
        targetValue = if(iniciaanim) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800),
            repeatMode = RepeatMode.Reverse
        )
    )
    LaunchedEffect(key1 = true){
        iniciaanim = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(UnicarScreen.inicioScreen.name)

    }
    splash(valorAlpha = alphaAnim.value)
}

@Composable
fun splash(valorAlpha: Float){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.azul1)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.unicar_sinfondo),
            contentDescription = "logo Unicar",
            modifier = Modifier.height(300.dp).alpha(alpha = valorAlpha)
        )
    }
}

@Preview
@Composable
fun abrirAppPreview(){
    splash(valorAlpha = 1f)
}
