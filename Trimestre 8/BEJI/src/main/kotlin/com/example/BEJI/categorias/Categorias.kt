package com.example.BEJI.categorias

data class Categorias (
    private var id: Int,
    private var name: String

){
    //geters
    fun getId(): Int{return this.id}
    fun getName(): String{return this.name}
    //seters
    fun setId(id: Int){this.id = id}
    fun setName(name: String){this.name = name}
}