package com.example.appinterface.Usuario

data class Usuario(
    val id: Int? = null,
    val numDoc: String,
    val nombres: String,
    val apellidos: String,
    val direccion: String,
    val email: String,
    val numTel: String,
    val fecNac: String,
    val password: String,
    val tipodocId: Long,
    val rolId: Long
)