package edu.unicauca.aplimovil.unicar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.unicauca.aplimovil.unicar.ui.*

enum class UnicarScreen() {
    abrirApp,
    inicioScreen,
    Registro,
    inicioSesionScreen,
    homeConductorScreen,
    construccionScreen
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

        //Inicio App
        composable(route = UnicarScreen.inicioScreen.name){
            MainScreen(navController)
        }

        //Registro de usuario pasajero
        composable(route = UnicarScreen.Registro.name){
            registroScreen(Modifier,viewModel)
        }

        //Incio de sesión de usuario conductor
        composable(route = UnicarScreen.inicioSesionScreen.name){
            inicioSesionScreen(navController,viewModel)
        }

        //En contrucción
        composable(route = UnicarScreen.construccionScreen.name){
            construccionScreen()
        }

    }
}