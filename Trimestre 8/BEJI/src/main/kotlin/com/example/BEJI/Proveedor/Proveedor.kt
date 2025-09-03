package com.example.BEJI.Proveedor

class Proveedor(
    private var id : Int,
    private var nombre:String,
    private var nit :String,
    private var celular: String,
    private var email: String,
    private var direccion: String
){
    //getters
    fun getId(): Int{return  this.id}
    fun getNombre(): String{return this.nombre}
    fun getNit(): String{return this.nit}
    fun getCelular(): String{return this.celular}
    fun getEmail(): String{return this.email}
    fun getDireccion(): String{return this.direccion}
}