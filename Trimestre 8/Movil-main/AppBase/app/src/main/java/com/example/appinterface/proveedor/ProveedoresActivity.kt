package com.example.appinterface.proveedor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.Adapter.ProveedorAdapter
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProveedoresActivity : AppCompatActivity() {

    private lateinit var adapter: ProveedorAdapter
    private lateinit var rvProveedores: RecyclerView
    private var proveedores: List<Proveedor> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proveedores)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Inventarios Sport10"
            setDisplayHomeAsUpEnabled(true) //
        }

        val btnAgregarProveedor = findViewById<Button>(R.id.btnAgregarProveedor)
        btnAgregarProveedor.setOnClickListener {
            val intent = Intent(this, AddProveedorActivity::class.java)
            startActivity(intent)

        }


        rvProveedores = findViewById(R.id.rvProveedores)
        rvProveedores.layoutManager = LinearLayoutManager(this)

        adapter = ProveedorAdapter(
            proveedores,
            onEditar = { proveedor -> editarProveedor(proveedor) },
            onEliminar = { proveedor -> eliminarProveedor(proveedor) }
        )

        rvProveedores.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        cargarProveedores()
    }

    private fun cargarProveedores() {
        RetrofitInstance.apiProveedores.getProveedores()
            .enqueue(object : Callback<List<Proveedor>> {
                override fun onResponse(call: Call<List<Proveedor>>, response: Response<List<Proveedor>>) {
                    if (response.isSuccessful) {
                        proveedores = response.body() ?: emptyList()
                        adapter.updateList(proveedores)
                    } else {
                        Toast.makeText(this@ProveedoresActivity, "Error al cargar proveedores", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<Proveedor>>, t: Throwable) {
                    Log.e("API_ERROR", "Error: ${t.message}")
                    Toast.makeText(this@ProveedoresActivity, "Fallo de conexión", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun editarProveedor(proveedor: Proveedor) {
        Toast.makeText(this, "Editar: ${proveedor.nombre}", Toast.LENGTH_SHORT).show()
        // TODO: Abre un formulario para editar si implementas edición
    }

    private fun eliminarProveedor(proveedor: Proveedor) {
        proveedor.id?.let { id ->
            RetrofitInstance.apiProveedores.deleteProveedor(id)
                .enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@ProveedoresActivity, "Proveedor eliminado", Toast.LENGTH_SHORT).show()
                            cargarProveedores()
                        } else {
                            Toast.makeText(
                                this@ProveedoresActivity,
                                "Error al eliminar: ${response.code()}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(
                            this@ProveedoresActivity,
                            "Error de red: ${t.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
