package edu.unicauca.aplimovil.unicar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
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
    val uiState by viewModel.uiState.collectAsState()

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
            MainScreen(navController,modifier,viewModel)
        }

        //Registro de usuario pasajero
        composable(route = UnicarScreen.Registro.name){
            registroScreen(navController,Modifier,viewModel)
        }

        //Incio de sesión de usuario conductor
        composable(route = UnicarScreen.inicioSesionScreen.name){
            inicioSesionScreen(navController,viewModel)
        }

        //Incio de sesión de usuario conductor
        composable(route = UnicarScreen.homeConductorScreen.name){
            homeConductorScreen(navController,modifier,viewModel,uiState)
        }

        //En contrucción
        composable(route = UnicarScreen.construccionScreen.name){
            construccionScreen()
        }

    }
}