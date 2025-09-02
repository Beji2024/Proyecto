package com.example.BEJI.Estado_venta

data class EstadoVenta(
    private var id: Int,
    private var nombre:String
) {
    fun getId():Int{return this.id}
    fun getNombre():String{return this.nombre}
}