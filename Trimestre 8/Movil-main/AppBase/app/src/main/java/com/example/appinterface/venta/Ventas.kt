package com.example.appinterface.venta

import com.google.gson.annotations.SerializedName

data class Ventas(
    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("nombreCli")
    val nombreCli: String,

    @SerializedName("direccionCli")
    val direccionCli: String,

    @SerializedName("correoCli")
    val correoCli: String,

    @SerializedName("numTelCli")
    val numTelCli: String,

    @SerializedName("numDocCli")
    val numDocCli: String,

    @SerializedName("productoId")
    val productoId: Long,

    @SerializedName("cantidad")
    val cantidad: Int,

    @SerializedName("vendedorId")
    val vendedorId: Long,

    @SerializedName("estadoId")
    val estadoId: Long = 1
)

