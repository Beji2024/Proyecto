package com.example.appinterface.Api


import retrofit2.http.*
import com.example.appinterface.Productos.Productos


import retrofit2.Call



interface ProductosApi {
    @GET("productos")
    fun getProductos(): Call<List<Productos>>

    @GET("productos/subcategoria/{id}")
    fun getProductosPorSubcategoria(@Path("id") id: Int): Call<List<Productos>>

    @GET("productos/categoria/{id}")
    fun getProductosPorCategoria(@Path("id") id: Int): Call<List<Productos>>

    @POST("productos")
    fun crearProducto(@Body producto: Productos): Call<String>

    @PUT("productos/{id}")
    fun actualizarProducto(@Path("id") id: Int, @Body producto: Productos): Call<String>

    @DELETE("productos/{id}")
    fun eliminarProducto(@Path("id") id: Int): Call<String>
}