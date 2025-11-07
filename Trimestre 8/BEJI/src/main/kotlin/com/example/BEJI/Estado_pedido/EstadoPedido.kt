package com.example.BEJI.Estado_pedido

data class EstadoPedido(
    private var id : Int,
    private var nombre: String,
) {
    fun getId(): Int {return this.id}
    fun getNombre(): String{return this.nombre}
}