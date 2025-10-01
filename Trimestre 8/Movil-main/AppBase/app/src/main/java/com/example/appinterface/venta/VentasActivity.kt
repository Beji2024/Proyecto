package com.example.appinterface.venta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class VentasActivity : AppCompatActivity() {

    private lateinit var rvVentas: RecyclerView
    private lateinit var ventasAdapter: VentasAdapter
    private lateinit var listaVentas: MutableList<Ventas>
    private lateinit var btnAgregarVenta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventas)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Inventarios Sport10"
            setDisplayHomeAsUpEnabled(true)
        }

        rvVentas = findViewById(R.id.rvVentas)
        listaVentas = mutableListOf()

        ventasAdapter = VentasAdapter(
            listaVentas,
            onEditar = { venta -> mostrarFormularioEditarVenta(venta) },
            onEliminar = { venta -> confirmarEliminar(venta) }
        )

        rvVentas.adapter = ventasAdapter
        rvVentas.layoutManager = LinearLayoutManager(this)

        // Botón Agregar Venta
        btnAgregarVenta = findViewById(R.id.btnAgregarVenta)
        btnAgregarVenta.setOnClickListener { mostrarFormularioCrearVenta() }

        obtenerVentas()
    }

    private fun mostrarFormularioCrearVenta() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Crear Venta")
        val view = layoutInflater.inflate(R.layout.formulario_venta, null)
        builder.setView(view)

        val etCantidad = view.findViewById<EditText>(R.id.etCantidad)
        val etNumDoc = view.findViewById<EditText>(R.id.etNumDoc)
        val etProductoId = view.findViewById<EditText>(R.id.etProductoId)
        val etVendedorId = view.findViewById<EditText>(R.id.etVendedorId)
        val etEstadoId = view.findViewById<EditText>(R.id.etEstadoId)
        val etCorreo = view.findViewById<EditText>(R.id.etCorreo)
        val etNombreCli = view.findViewById<EditText>(R.id.etNombreCli)
        val etDireccionCli = view.findViewById<EditText>(R.id.etDireccionCli)
        val etNumTelCli = view.findViewById<EditText>(R.id.etNumTelCli)

        builder.setPositiveButton("Crear") { _, _ ->
            if (etCantidad.text.isBlank() || etNumDoc.text.isBlank() ||
                etProductoId.text.isBlank() || etVendedorId.text.isBlank() ||
                etEstadoId.text.isBlank() || etCorreo.text.isBlank() ||
                etNombreCli.text.isBlank() || etDireccionCli.text.isBlank() ||
                etNumTelCli.text.isBlank()
            ) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            val nuevaVenta = Ventas(
                id = null,
                nombreCli = etNombreCli.text.toString(),
                direccionCli = etDireccionCli.text.toString(),
                correoCli = etCorreo.text.toString(),
                numTelCli = etNumTelCli.text.toString(),
                numDocCli = etNumDoc.text.toString(),
                productoId = etProductoId.text.toString().toLong(),
                cantidad = etCantidad.text.toString().toInt(),
                vendedorId = etVendedorId.text.toString().toLong(),
                estadoId = etEstadoId.text.toString().toLongOrNull() ?: 1
            )

            Log.d("API", "JSON a enviar: $nuevaVenta")
            crearVenta(nuevaVenta)
        }

        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun crearVenta(nuevaVenta: Ventas) {
        RetrofitInstance.api.registrarVenta(nuevaVenta)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        listaVentas.add(nuevaVenta)
                        ventasAdapter.notifyItemInserted(listaVentas.size - 1)
                        val msg = response.body()?.string() ?: "Venta agregada"
                        Toast.makeText(this@VentasActivity, msg, Toast.LENGTH_SHORT).show()
                    } else {
                        val errorMsg = response.errorBody()?.string()
                        Toast.makeText(
                            this@VentasActivity,
                            "Error al agregar venta: $errorMsg",
                            Toast.LENGTH_LONG
                        ).show()
                        Log.e("API", "Error agregar venta: $errorMsg")
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(
                        this@VentasActivity,
                        "Fallo en la conexión: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    Log.e("API", "Fallo en agregar venta: ${t.message}")
                }
            })
    }

    private fun mostrarFormularioEditarVenta(venta: Ventas) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Editar Venta")
        val view = layoutInflater.inflate(R.layout.formulario_venta, null)
        builder.setView(view)

        val etCantidad = view.findViewById<EditText>(R.id.etCantidad)
        val etNumDoc = view.findViewById<EditText>(R.id.etNumDoc)
        val etProductoId = view.findViewById<EditText>(R.id.etProductoId)
        val etVendedorId = view.findViewById<EditText>(R.id.etVendedorId)
        val etEstadoId = view.findViewById<EditText>(R.id.etEstadoId)
        val etCorreo = view.findViewById<EditText>(R.id.etCorreo)
        val etNombreCli = view.findViewById<EditText>(R.id.etNombreCli)
        val etDireccionCli = view.findViewById<EditText>(R.id.etDireccionCli)
        val etNumTelCli = view.findViewById<EditText>(R.id.etNumTelCli)

        etCantidad.setText(venta.cantidad.toString())
        etNumDoc.setText(venta.numDocCli)
        etProductoId.setText(venta.productoId.toString())
        etVendedorId.setText(venta.vendedorId.toString())
        etEstadoId.setText(venta.estadoId.toString())
        etCorreo.setText(venta.correoCli)
        etNombreCli.setText(venta.nombreCli)
        etDireccionCli.setText(venta.direccionCli)
        etNumTelCli.setText(venta.numTelCli)

        builder.setPositiveButton("Guardar") { _, _ ->
            if (etCantidad.text.isBlank() || etNumDoc.text.isBlank() ||
                etProductoId.text.isBlank() || etVendedorId.text.isBlank() ||
                etEstadoId.text.isBlank() || etCorreo.text.isBlank() ||
                etNombreCli.text.isBlank() || etDireccionCli.text.isBlank() ||
                etNumTelCli.text.isBlank()
            ) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            val ventaActualizada = venta.copy(
                cantidad = etCantidad.text.toString().toInt(),
                numDocCli = etNumDoc.text.toString(),
                productoId = etProductoId.text.toString().toLong(),
                vendedorId = etVendedorId.text.toString().toLong(),
                estadoId = etEstadoId.text.toString().toLong(),
                correoCli = etCorreo.text.toString(),
                nombreCli = etNombreCli.text.toString(),
                direccionCli = etDireccionCli.text.toString(),
                numTelCli = etNumTelCli.text.toString()
            )

            actualizarVenta(ventaActualizada)
        }

        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun actualizarVenta(venta: Ventas) {
        venta.id?.let { id ->
            RetrofitInstance.api.actualizarVenta(id.toInt(), venta)
                .enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if (response.isSuccessful) {
                            val index = listaVentas.indexOfFirst { it.id == venta.id }
                            if (index != -1) {
                                listaVentas[index] = venta
                                ventasAdapter.notifyItemChanged(index)
                            }
                            val msg = response.body()?.string() ?: "Venta actualizada"
                            Toast.makeText(this@VentasActivity, msg, Toast.LENGTH_SHORT).show()
                        } else {
                            val errorMsg = response.errorBody()?.string()
                            Toast.makeText(
                                this@VentasActivity,
                                "Error al actualizar: $errorMsg",
                                Toast.LENGTH_LONG
                            ).show()
                            Log.e("API", "Error actualizar venta: $errorMsg")
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Toast.makeText(
                            this@VentasActivity,
                            "Fallo en la conexión: ${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                        Log.e("API", "Fallo al actualizar venta: ${t.message}")
                    }
                })
        } ?: run {
            Toast.makeText(this, "ID de venta inválido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun confirmarEliminar(venta: Ventas) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar venta")
            .setMessage("¿Seguro que deseas eliminar esta venta?")
            .setPositiveButton("Sí") { _, _ -> eliminarVenta(venta) }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun eliminarVenta(venta: Ventas) {
        venta.id?.toInt()?.let { idInt ->
            RetrofitInstance.api.eliminarVenta(idInt).enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        val index = listaVentas.indexOf(venta)
                        if (index != -1) {
                            listaVentas.removeAt(index)
                            ventasAdapter.notifyItemRemoved(index)
                        }
                        val msg = response.body()?.string() ?: "Venta eliminada"
                        Toast.makeText(this@VentasActivity, msg, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@VentasActivity, "Error al eliminar venta", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(
                        this@VentasActivity,
                        "Fallo en la conexión: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        }
    }

    private fun obtenerVentas() {
        RetrofitInstance.api.obtenerVentas().enqueue(object : Callback<List<Ventas>> {
            override fun onResponse(call: Call<List<Ventas>>, response: Response<List<Ventas>>) {
                if (response.isSuccessful && response.body() != null) {
                    listaVentas.clear()
                    listaVentas.addAll(response.body()!!)
                    ventasAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Ventas>>, t: Throwable) {
                Toast.makeText(this@VentasActivity, "Error al obtener ventas", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
