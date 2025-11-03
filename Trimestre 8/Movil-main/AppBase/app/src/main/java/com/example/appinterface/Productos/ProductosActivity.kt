package com.example.appinterface.Productos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.Adapter.ProductosAdapter
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductosAdapter
    private lateinit var btnGestion: Button
    private var listaProductos: List<Productos> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        recyclerView = findViewById(R.id.recycler)
        btnGestion = findViewById(R.id.btn)

        adapter = ProductosAdapter(listaProductos,
            onEditClick = { producto -> editarProducto(producto) },
            onDeleteClick = { producto -> eliminarProducto(producto) }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnGestion.setOnClickListener {
            startActivity(Intent(this, GestionProductosActivity::class.java))
        }

        cargarProductos()
    }

    private fun cargarProductos() {
        RetrofitInstance.instance.getProductos().enqueue(object : Callback<List<Productos>> {
            override fun onResponse(call: Call<List<Productos>>, response: Response<List<Productos>>) {
                if (response.isSuccessful) {
                    listaProductos = response.body() ?: emptyList()
                    adapter.updateList(listaProductos)
                }
            }

            override fun onFailure(call: Call<List<Productos>>, t: Throwable) {
                Toast.makeText(this@ProductosActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun editarProducto(producto: Productos) {
        val intent = Intent(this, GestionProductosActivity::class.java)
        intent.putExtra("producto", producto)
        startActivity(intent)
    }

    private fun eliminarProducto(producto: Productos) {
        RetrofitInstance.instance.eliminarProducto(producto.id_pro).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(this@ProductosActivity, response.body(), Toast.LENGTH_SHORT).show()
                cargarProductos()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@ProductosActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
