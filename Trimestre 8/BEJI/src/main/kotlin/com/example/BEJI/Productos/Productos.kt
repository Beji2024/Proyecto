package com.example.BEJI.Productos

data class Productos (
    private var id_pro: Int,
    private var cantidad: Int,
    private var nombre: String,
    private var talla: Int,
    private var precio_venta: Int,
    private var precio_compra: Int,
    private var material: String,
    private var color: String,
    private var imagen: String,
    private var sub_mer: Int
){
    //geters
    fun getId_pro(): Int {return this.id_pro}
    fun getCantidad(): Int {return this.cantidad}
    fun getNombre(): String {return this.nombre}
    fun getTalla(): Int {return this.talla}
    fun getPrecio_venta(): Int {return this.precio_venta}
    fun getPrecio_compra(): Int {return this.precio_compra}
    fun getMaterial(): String{return this.material}
    fun getColor(): String{return this.color}
    fun getImagen(): String{return this.imagen}
    fun getSub_mer(): Int {return this.sub_mer}
    //seters
    fun setId_pro(id_pro: Int){this.id_pro=id_pro}
    fun setCantidad(cantidad: Int){this.cantidad=cantidad}
    fun setNombre(nombre: String){this.nombre=nombre}
    fun setTalla(talla: Int){this.talla=talla}
    fun setPrecio_venta(precio_venta: Int){this.precio_venta=precio_venta}
    fun setPrecio_compra(precio_compra: Int){this.precio_compra=precio_compra}
    fun setMaterial(material: String){this.material=material}
    fun setColor(color: String){this.color=color}
    fun setImagen(imagen: String){ this.imagen=imagen}
    fun setSub_mer(sub_mer: Int){this.sub_mer=sub_mer}

}