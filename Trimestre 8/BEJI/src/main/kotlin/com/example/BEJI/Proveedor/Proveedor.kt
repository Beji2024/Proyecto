package com.example.BEJI.Proveedor


data class Proveedor(
    private var nombre:String,
    private var nit :String,
    private var celular: String,
    private var email: String,
    private var direccion: String
){
    //getters
    fun getNombre(): String{return this.nombre}
    fun getNit(): String{return this.nit}
    fun getCelular(): String{return this.celular}
    fun getEmail(): String{return this.email}
    fun getDireccion(): String{return this.direccion}
}