package com.example.BEJI.subcategoria

data class Subcategorias(
 private var id_sub: Int,
 private var nom_sub: String,
 private var cat_sub: Int
) {
//geters
 fun getid_sub():Int{return this.id_sub}
 fun getnom_sub(): String{return this.nom_sub}
 fun getcat_sub(): Int{return this.cat_sub}

}