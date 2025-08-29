package com.example.BEJI.venta

data class Ventas(
    private var nombre_cli: String,
    private var direccion_cli: String,
    private var correo_cli: String,
    private var num_tel_cli: String,
    private var num_doc_cli: String,
    private var producto_id: Long,
    private var cantidad: Int,
    private var vendedor_id: Long,
    private var estado_id: Long = 1
){
    // Getters
    fun getNombreCli(): String = nombre_cli
    fun getDireccionCli(): String = direccion_cli
    fun getCorreoCli(): String = correo_cli
    fun getNumTelCli(): String = num_tel_cli
    fun getNumDocCli(): String = num_doc_cli
    fun getProductoId(): Long = producto_id
    fun getCantidad(): Int = cantidad
    fun getVendedorId(): Long = vendedor_id
    fun getEstadoId(): Long = estado_id

    // Setters
    fun setNombreCli(nombre_cli: String){ this.nombre_cli = nombre_cli }
    fun setDireccionCli(direccion_cli: String){ this.direccion_cli = direccion_cli }
    fun setCorreoCli(correo_cli: String){ this.correo_cli = correo_cli }
    fun setNumTelCli(num_tel_cli: String){ this.num_tel_cli = num_tel_cli }
    fun setNumDocCli(num_doc_cli: String){ this.num_doc_cli = num_doc_cli }
    fun setProductoId(producto_id: Long){ this.producto_id = producto_id }
    fun setCantidad(cantidad: Int){ this.cantidad = cantidad }
    fun setVendedorId(vendedor_id: Long){ this.vendedor_id = vendedor_id }
    fun setEstadoId(estado_id: Long){ this.estado_id = estado_id }
}
