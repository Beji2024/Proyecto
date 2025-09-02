package com.example.BEJI.estado_venta

data class EstadoVenta(
    private var id: Int,
    private var nombre:String
) {
    fun getId():Int{return this.id}
    fun getNombre():String{return this.nombre}
}