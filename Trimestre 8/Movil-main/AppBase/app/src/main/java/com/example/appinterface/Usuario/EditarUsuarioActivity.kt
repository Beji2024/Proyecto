package com.example.appinterface.Usuario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import com.google.android.material.appbar.MaterialToolbar
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditarUsuarioActivity : AppCompatActivity() {

    private lateinit var etNumDoc: EditText
    private lateinit var etNombres: EditText
    private lateinit var etApellidos: EditText
    private lateinit var etDireccion: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etNumTel: EditText
    private lateinit var etFecNac: EditText
    private lateinit var etPassword: EditText
    private lateinit var etTipodoc: EditText
    private lateinit var etRolId: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.editar_usuario)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Editar usuario"
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { finish() }

        etNumDoc = findViewById(R.id.numdoc)
        etNombres = findViewById(R.id.nombres)
        etApellidos = findViewById(R.id.apellidos)
        etDireccion = findViewById(R.id.direccion)
        etCorreo = findViewById(R.id.correo)
        etNumTel = findViewById(R.id.numTel)
        etFecNac = findViewById(R.id.fecNac)
        etPassword = findViewById(R.id.password)
        etTipodoc = findViewById(R.id.tipodoc)
        etRolId = findViewById(R.id.rolId)

        val btnActualizar = findViewById<Button>(R.id.btnActualizar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        etNumDoc.setText(intent.getStringExtra("numDoc"))
        etNombres.setText(intent.getStringExtra("nombres"))
        etApellidos.setText(intent.getStringExtra("apellidos"))
        etDireccion.setText(intent.getStringExtra("direccion"))
        etCorreo.setText(intent.getStringExtra("email"))
        etNumTel.setText(intent.getStringExtra("numTel"))
        etFecNac.setText(intent.getStringExtra("fecNac"))
        etPassword.setText(intent.getStringExtra("password"))
        etTipodoc.setText(intent.getIntExtra("tipodoc", 0).toString())
        etRolId.setText(intent.getIntExtra("rolId", 0).toString())

        btnActualizar.setOnClickListener {
            actualizarUsuario()
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }

    private fun actualizarUsuario() {
        val numDoc = etNumDoc.text.toString()
        val usuario = Usuario(
            numDoc = numDoc,
            nombres = etNombres.text.toString(),
            apellidos = etApellidos.text.toString(),
            direccion = etDireccion.text.toString(),
            email = etCorreo.text.toString(),
            numTel = etNumTel.text.toString(),
            fecNac = etFecNac.text.toString(),
            password = etPassword.text.toString(),
            tipodocId = etTipodoc.text.toString().toLongOrNull() ?: 0,
            rolId = etRolId.text.toString().toLongOrNull() ?: 0
        )

        RetrofitInstance.api3kotlin.updateUsuario(numDoc, usuario)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@EditarUsuarioActivity, "Usuario actualizado correctamente", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this@EditarUsuarioActivity, "Error al actualizar: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@EditarUsuarioActivity, "Error de red: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}