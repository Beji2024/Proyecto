package com.example.appinterface.proveedor

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import com.google.gson.Gson
import com.google.android.material.appbar.MaterialToolbar
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddProveedorActivity : AppCompatActivity() {

    private lateinit var etNit: EditText
    private lateinit var etName: EditText
    private lateinit var etDireccion: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_proveedor)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        if (toolbar == null) {
            Log.e("AddProveedorActivity", "toolbar es null -> revisa include y el id customToolbar")
        } else {
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                title = "Agregar Proveedor"
                setDisplayHomeAsUpEnabled(true)
            }

            toolbar.setNavigationOnClickListener {
                Log.d("AddProveedorActivity", "Navigation click - finishing activity")
                finish()
            }
        }

        etNit = findViewById(R.id.etNit)
        etName = findViewById(R.id.etName)
        etDireccion = findViewById(R.id.etDireccion)
        etTelefono = findViewById(R.id.etTelefono)
        etEmail = findViewById(R.id.etEmail)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val nit = etNit.text.toString().trim()
            val name = etName.text.toString().trim()
            val direccion = etDireccion.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (nit.isEmpty() || name.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val proveedor = Proveedor(
                nombre = name,
                nit = nit,
                celular = telefono,
                email = email,
                direccion = direccion
            )
            val gson = Gson()
            Log.d("JSON", gson.toJson(proveedor))

            addProveedor(proveedor)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun addProveedor(proveedor: Proveedor) {
        val call = RetrofitInstance.apiProveedores.addProveedor(proveedor)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val responseText = response.body()?.string() ?: "Sin mensaje"
                    Toast.makeText(this@AddProveedorActivity, "Proveedor agregado con éxito: $responseText", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@AddProveedorActivity, "Error al agregar proveedor", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@AddProveedorActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
