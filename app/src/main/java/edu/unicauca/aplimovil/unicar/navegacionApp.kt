package edu.unicauca.aplimovil.unicar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.unicauca.aplimovil.unicar.ui.OrderViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.unicauca.aplimovil.unicar.ui.MainScreen
import edu.unicauca.aplimovil.unicar.ui.abrirApp

enum class UnicarScreen() {
    abrirApp,
    inicioScreen,
    Registro,
    inicioSesionScreen,
    homeConductorScreen
}

@Composable
fun UnicarApp(
    viewModel: OrderViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = UnicarScreen.abrirApp.name
    ){
        //abrir App
        composable(route = UnicarScreen.abrirApp.name){
            abrirApp(navController)
        }

        //inicio App
        composable(route = UnicarScreen.inicioScreen.name){
            MainScreen()
        }

    }
}