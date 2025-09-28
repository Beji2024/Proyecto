package com.example.appinterface.Api

import com.example.appinterface.Usuario.Usuario
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiServiceUsuario {

    // Obtener todos los usuarios
    @GET("/usuarios")
    fun getUsuarios(): Call<List<Usuario>>

    // Registrar un nuevo usuario
    @POST("/usuarios")
    fun postUsuarios(@Body usuario: Usuario): Call<ResponseBody>

    // Actualizar usuario (se pasa el numDoc en la URL)
    @PUT("usuarios/{numDoc}")
    fun updateUsuario(@Path("numDoc") numDoc: String, @Body usuario: Usuario): Call<ResponseBody>

    // Eliminar usuario por numDoc
    @DELETE("/usuarios/{numDoc}")
    fun deleteUsuario(@Path("numDoc") numDoc: String): Call<ResponseBody>


}
