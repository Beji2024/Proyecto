package com.example.BEJI.proveedors
import org.springframework.format.annotation.DateTimeFormat

data class Proveedors(
    private var nit :String,
    private var name:String,
    private var direccion: String,
    private var telefono: String,
    private var email: String,
){
    //getters
    fun getNit(): String{return this.nit}
    fun getName(): String{return this.name}
    fun getDireccion(): String{return this.direccion}
    fun getTelefono(): String{return this.telefono}
    fun getEmail(): String{return this.email}

    //setters
    fun setNit(nit: String){ this.nit = nit }
    fun setName(name:String){ this.name = name}
    fun setDireccion(direccion: String){ this.direccion = direccion}
    fun setTelefono(telefono: String){ this.telefono = telefono}
    fun setEmail(email: String){ this.email = email}

}