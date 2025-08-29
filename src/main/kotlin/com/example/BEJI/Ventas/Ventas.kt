package com.example.BEJI.venta

data class Venta(
    private var nombreCli: String,
    private var direccionCli: String,
    private var correoCli: String,
    private var numTelCli: String,
    private var numDocCli: String,
    private var productoId: Long,
    private var cantidad: Int,
    private var vendedorId: Long,
    private var estadoId: Long = 1
){
    // Getters
    fun getNombreCli(): String = nombreCli
    fun getDireccionCli(): String = direccionCli
    fun getCorreoCli(): String = correoCli
    fun getNumTelCli(): String = numTelCli
    fun getNumDocCli(): String = numDocCli
    fun getProductoId(): Long = productoId
    fun getCantidad(): Int = cantidad
    fun getVendedorId(): Long = vendedorId
    fun getEstadoId(): Long = estadoId

    // Setters
    fun setNombreCli(nombreCli: String){ this.nombreCli = nombreCli }
    fun setDireccionCli(direccionCli: String){ this.direccionCli = direccionCli }
    fun setCorreoCli(correoCli: String){ this.correoCli = correoCli }
    fun setNumTelCli(numTelCli: String){ this.numTelCli = numTelCli }
    fun setNumDocCli(numDocCli: String){ this.numDocCli = numDocCli }
    fun setProductoId(productoId: Long){ this.productoId = productoId }
    fun setCantidad(cantidad: Int){ this.cantidad = cantidad }
    fun setVendedorId(vendedorId: Long){ this.vendedorId = vendedorId }
    fun setEstadoId(estadoId: Long){ this.estadoId = estadoId }
}
