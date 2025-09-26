package com.example.appinterface.Usuario

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.let
import kotlin.text.toLong

class EditarUsuarioActivity : AppCompatActivity() {

    private lateinit var etNumDoc: EditText
    private lateinit var etNombres: EditText
    private lateinit var etApellidos: EditText
    private lateinit var etDireccion: EditText
    private lateinit var etEmail: EditText
    private lateinit var etNumTel: EditText
    private lateinit var etFecNac: EditText
    private lateinit var etPassword: EditText
    private lateinit var etTipodocId: EditText
    private lateinit var etRolId: EditText
    private lateinit var btnActualizar: Button
    private lateinit var btnCancelar: Button

    private var usuario: Usuario? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_usuario)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        if (toolbar == null) {
            Log.e("AddProveedorActivity", "toolbar es null -> revisa include y el id customToolbar")
        } else {
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                title = "Registrar Usuario"
                setDisplayHomeAsUpEnabled(true)
            }

            toolbar.setNavigationOnClickListener {
                Log.d("AddProveedorActivity", "Navigation click - finishing activity")
                finish()
            }
        }

        // Inicializar vistas
        etNumDoc = findViewById(R.id.numdoc)
        etNombres = findViewById(R.id.nombres)
        etApellidos = findViewById(R.id.apellidos)
        etDireccion = findViewById(R.id.direccion)
        etEmail = findViewById(R.id.correo)
        etNumTel = findViewById(R.id.numTel)
        etFecNac = findViewById(R.id.fecNac)
        etPassword = findViewById(R.id.password)
        etTipodocId = findViewById(R.id.tipodoc)
        etRolId = findViewById(R.id.rolId)
        btnActualizar = findViewById(R.id.btnActualizar)
        btnCancelar = findViewById(R.id.btnCancelar)

        // Recuperar usuario enviado desde UsuarioActivity
        usuario = intent.getSerializableExtra("usuario") as? Usuario

        usuario?.let {
            etNumDoc.setText(it.numDoc)
            etNombres.setText(it.nombres)
            etApellidos.setText(it.apellidos)
            etDireccion.setText(it.direccion)
            etEmail.setText(it.email)
            etNumTel.setText(it.numTel)
            etFecNac.setText(it.fecNac)
            etPassword.setText(it.password)
            etTipodocId.setText(it.tipodocId?.toString() ?: "")
            etRolId.setText(it.rolId?.toString() ?: "")
        }

        btnActualizar.setOnClickListener {
            actualizarUsuario()
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }

    private fun actualizarUsuario() {
        val numDoc = etNumDoc.text.toString()
        val usuarioActualizado = Usuario(
            id = usuario?.id,
            numDoc = numDoc,
            nombres = etNombres.text.toString(),
            apellidos = etApellidos.text.toString(),
            direccion = etDireccion.text.toString(),
            email = etEmail.text.toString(),
            numTel = etNumTel.text.toString(),
            fecNac = etFecNac.text.toString(),
            password = etPassword.text.toString(),
            tipodocId = etTipodocId.text.toString().toLong(),
            rolId = etRolId.text.toString().toLong()
        )

        val gson = Gson()
        println("JSON enviado: ${gson.toJson(usuarioActualizado)}")

        RetrofitInstance.api3kotlin.putUsuarios(numDoc, usuarioActualizado)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@EditarUsuarioActivity, "Usuario actualizado", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this@EditarUsuarioActivity, "Error al actualizar: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@EditarUsuarioActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
