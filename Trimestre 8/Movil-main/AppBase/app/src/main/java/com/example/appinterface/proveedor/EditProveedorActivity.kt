package com.example.appinterface.proveedor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import com.google.android.material.appbar.MaterialToolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProveedorActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etNit: EditText
    private lateinit var etCelular: EditText
    private lateinit var etEmail: EditText
    private lateinit var etDireccion: EditText
    private var proveedorId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_proveedores)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Editar Proveedor"
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { finish() }

        etNombre = findViewById(R.id.etNombre)
        etNit = findViewById(R.id.etNit)
        etCelular = findViewById(R.id.etCelular)
        etEmail = findViewById(R.id.etEmail)
        etDireccion = findViewById(R.id.etDireccion)
        val btnActualizar = findViewById<Button>(R.id.btnActualizar)

        proveedorId = intent.getIntExtra("id", -1)

        etNombre.setText(intent.getStringExtra("nombre") ?: "")
        etNit.setText(intent.getStringExtra("nit") ?: "")
        etCelular.setText(intent.getStringExtra("celular") ?: "")
        etEmail.setText(intent.getStringExtra("email") ?: "")
        etDireccion.setText(intent.getStringExtra("direccion") ?: "")

        btnActualizar.setOnClickListener {
            actualizarProveedor()
        }
    }

    private fun actualizarProveedor() {
        val id = proveedorId ?: return

        val proveedor = Proveedor(
            id,
            etNombre.text.toString(),
            etNit.text.toString(),
            etCelular.text.toString(),
            etEmail.text.toString(),
            etDireccion.text.toString()
        )

        RetrofitInstance.apiProveedores.updateProveedor(id, proveedor)
            .enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        val mensaje = response.body() ?: "Actualizado"
                        Toast.makeText(this@EditProveedorActivity, mensaje, Toast.LENGTH_SHORT).show()

                        if (mensaje.contains("exito", ignoreCase = true)) {
                            val intent = Intent(this@EditProveedorActivity, ProveedoresActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        Toast.makeText(this@EditProveedorActivity, "Error al actualizar: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@EditProveedorActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
