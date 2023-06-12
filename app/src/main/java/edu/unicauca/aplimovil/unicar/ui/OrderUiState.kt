package edu.unicauca.aplimovil.unicar.ui

data class OrderUiState(
    /** correo del usuario logueado */
    var emailUser: String = "",

    /** id del usuario logueado */
    var idUser: Int = 0,

    /** nombre del usuario logueado */
    var nameUser: String = "",

    /** información de la última ruta del usuario logueado */
    var idRuta: Int = 0,
    var destino: String = "",
    var fecha: String = "",
    var horaSalida: String = "",
    var cupos: String = ""
)
