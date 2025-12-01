package com.example.appinterface.Api

import com.example.appinterface.proveedor.Proveedor
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ProveedoresApi {
    @GET("proveedores")
    fun getProveedores(): Call<List<Proveedor>>

    @GET("proveedores/{id}")
    fun getProveedorById(@Path("id") id: Int): Call<Proveedor>

    @GET("proveedores/nit/{nit}")
    fun getProveedorByNit(@Path("nit") nit: String): Call<Proveedor>

    @POST("proveedores")
    fun addProveedor(@Body proveedor: Proveedor): Call<ResponseBody>

    @PUT("proveedores/{id}")
    fun updateProveedor(@Path("id") id: Int, @Body proveedor: Proveedor): Call<String>

    @DELETE("proveedores/{id}")
    fun deleteProveedor(@Path("id") id: Int): Call<Void>
}
