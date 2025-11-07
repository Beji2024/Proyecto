package com.example.appinterface.Productos


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GestionProductosActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etCantidad: EditText
    private lateinit var etTalla: EditText
    private lateinit var etPrecioVenta: EditText
    private lateinit var etPrecioCompra: EditText
    private lateinit var etMaterial: EditText
    private lateinit var etColor: EditText
    private lateinit var etImagen: EditText
    private lateinit var etSubMer: EditText
    private lateinit var btnGuardar: Button

    private var productoEditado: Productos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestion_productos)

        // Referencias del XML
        etNombre = findViewById(R.id.etNombre)
        etCantidad = findViewById(R.id.etCantidad)
        etTalla = findViewById(R.id.etTalla)
        etPrecioVenta = findViewById(R.id.etPrecioVenta)
        etPrecioCompra = findViewById(R.id.etPrecioCompra)
        etMaterial = findViewById(R.id.etMaterial)
        etColor = findViewById(R.id.etColor)
        etImagen = findViewById(R.id.etImagen)
        etSubMer = findViewById(R.id.etSubMer)
        btnGuardar = findViewById(R.id.btnGuardar)

        // Verificar si viene un producto para edición
        productoEditado = intent.getSerializableExtra("producto") as? Productos

        productoEditado?.let {
            etNombre.setText(it.nombre)
            etCantidad.setText(it.cantidad.toString())
            etTalla.setText(it.talla.toString())
            etPrecioVenta.setText(it.precio_venta.toString())
            etPrecioCompra.setText(it.precio_compra.toString())
            etMaterial.setText(it.material)
            etColor.setText(it.color)
            etImagen.setText(it.imagen)
            etSubMer.setText(it.sub_mer.toString())
        }

        // Acción del botón
        btnGuardar.setOnClickListener {
            if (productoEditado == null) {
                crearProducto()
            } else {
                actualizarProducto()
            }
        }
    }

    private fun crearProducto() {
        val producto = leerCampos() ?: return

        RetrofitInstance.instance.crearProducto(producto).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(
                    this@GestionProductosActivity,
                    response.body() ?: "Producto creado",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@GestionProductosActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun actualizarProducto() {
        val producto = leerCampos()?.copy(id_pro = productoEditado!!.id_pro) ?: return

        RetrofitInstance.instance.actualizarProducto(producto.id_pro, producto).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(
                    this@GestionProductosActivity,
                    response.body() ?: "Producto actualizado",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@GestionProductosActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun leerCampos(): Productos? {
        val nombre = etNombre.text.toString()
        val cantidad = etCantidad.text.toString().toIntOrNull()
        val talla = etTalla.text.toString().toIntOrNull()
        val precioVenta = etPrecioVenta.text.toString().toIntOrNull()
        val precioCompra = etPrecioCompra.text.toString().toIntOrNull()
        val material = etMaterial.text.toString()
        val color = etColor.text.toString()
        val imagen = etImagen.text.toString()
        val subMer = etSubMer.text.toString().toIntOrNull()

        if (nombre.isEmpty() || cantidad == null || talla == null || precioVenta == null ||
            precioCompra == null || material.isEmpty() || color.isEmpty() || subMer == null) {
            Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            return null
        }

        return Productos(
            id_pro = 0, // Se asigna solo en creación, el backend lo genera
            cantidad = cantidad,
            nombre = nombre,
            talla = talla,
            precio_venta = precioVenta,
            precio_compra = precioCompra,
            material = material,
            color = color,
            imagen = imagen,
            sub_mer = subMer
        )
    }
}