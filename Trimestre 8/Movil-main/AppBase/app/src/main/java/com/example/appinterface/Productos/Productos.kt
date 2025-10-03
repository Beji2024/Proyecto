package com.example.appinterface.Productos

import java.io.Serializable

data class Productos(
    var id_pro: Int,
    var cantidad: Int,
    var nombre: String,
    var talla: Int,
    var precio_venta: Int,
    var precio_compra: Int,
    var material: String,
    var color: String,
    var imagen: String,
    var sub_mer: Int
): Serializable