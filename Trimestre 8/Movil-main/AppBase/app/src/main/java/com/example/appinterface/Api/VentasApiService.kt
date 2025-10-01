package com.example.appinterface.Api

import com.example.appinterface.venta.Ventas
import okhttp3.ResponseBody

import retrofit2.Call
import retrofit2.http.*

interface VentasApi {

    @GET("ventas")
    fun obtenerVentas(): Call<List<Ventas>>


    @POST("registrarVenta")
    fun registrarVenta(@Body venta: Ventas): Call<ResponseBody>



    @PUT("actualizarVenta/{id}")
    fun actualizarVenta(@Path("id") id: Int, @Body venta: Ventas): Call<ResponseBody>



    @DELETE("eliminarVenta/{id}")
    fun eliminarVenta(@Path("id") id: Int): Call<okhttp3.ResponseBody>




}

