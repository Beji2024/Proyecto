package com.example.appinterface.Api

import com.example.appinterface.Usuario.Usuario
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiServiceUsuario {

    @GET("/usuarios")
    fun getUsuarios(): Call<List<Usuario>>

    @POST("/usuarios")
    fun postUsuarios(@Body usuario: Usuario): Call<ResponseBody>

    @PUT("usuarios/{numDoc}")
    fun updateUsuario(@Path("numDoc") numDoc: String, @Body usuario: Usuario): Call<ResponseBody>

    @DELETE("/usuarios/{numDoc}")
    fun deleteUsuario(@Path("numDoc") numDoc: String): Call<ResponseBody>
}
