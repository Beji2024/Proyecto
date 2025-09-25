package com.example.appinterface.proveedor

data class Proveedor(
    val id: Int? = null,
    val nombre: String,
    val nit: String,
    val celular: String,
    val email: String,
    val direccion: String
)