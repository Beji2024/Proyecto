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
import kotlin.text.isEmpty
import kotlin.text.toLongOrNull
import kotlin.text.trim

class RegistroUsuario : AppCompatActivity() {

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
    private lateinit var btnRegistrar: Button
    private lateinit var btnCancelar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_usuario)
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
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnCancelar = findViewById(R.id.btnCancelar)

        btnRegistrar.setOnClickListener {
            val numDoc = etNumDoc.text.toString().trim()
            val nombres = etNombres.text.toString().trim()
            val apellidos = etApellidos.text.toString().trim()
            val direccion = etDireccion.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val numTel = etNumTel.text.toString().trim()
            val fecNac = etFecNac.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val tipodocId = etTipodocId.text.toString()
            val rolId = etRolId.text.toString()

            if (numDoc.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() ||
                direccion.isEmpty() || email.isEmpty() || numTel.isEmpty() ||
                fecNac.isEmpty() || password.isEmpty() || tipodocId.isEmpty() || rolId.isEmpty()
            ) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val tipodocLong = tipodocId.toLongOrNull()
            val rolLong = rolId.toLongOrNull()

            if (tipodocLong == null || rolLong == null) {
                Toast.makeText(this, "Tipo de doc y rol deben ser números", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(
                id = 0,
                numDoc = numDoc,
                nombres = nombres,
                apellidos = apellidos,
                direccion = direccion,
                email = email,
                numTel = numTel,
                fecNac = fecNac,
                password = password,
                tipodocId = tipodocLong,
                rolId = rolLong
            )

            val gson = Gson()
            Log.d("Json", gson.toJson(usuario))

            registroUsuario(usuario)
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }

    private fun registroUsuario(usuario: Usuario) {
        val call = RetrofitInstance.api3kotlin.postUsuarios(usuario)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val responseText = response.body()?.string() ?: "Sin mensaje"
                    Toast.makeText(this@RegistroUsuario, "Usuario registrado con éxito: $responseText", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@RegistroUsuario, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@RegistroUsuario, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}