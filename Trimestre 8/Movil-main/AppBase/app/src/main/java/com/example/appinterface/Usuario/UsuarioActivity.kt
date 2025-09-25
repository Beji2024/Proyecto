// app/src/main/java/com/example/appinterface/Usuarios/UsuarioActivity.kt
package com.example.appinterface.Usuario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.Adapter.UsuarioAdapter
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.isNullOrEmpty
import kotlin.collections.toMutableList
import kotlin.jvm.java
import kotlin.text.isEmpty

class UsuarioActivity : AppCompatActivity() {

    private lateinit var adapter: UsuarioAdapter
    private lateinit var rUsuario: RecyclerView
    private var usuarios: MutableList<Usuario> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usuario)

        val btnRegistroUsuario = findViewById<Button>(R.id.btnRegistrarUsuario)
        btnRegistroUsuario.setOnClickListener {
            val intent = Intent(this, RegistroUsuario::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rUsuario = findViewById(R.id.RecyUsuario)
        rUsuario.layoutManager = LinearLayoutManager(this)
        mostrarUsuarios()
    }

    override fun onResume() {
        super.onResume()
        mostrarUsuarios() // recarga al volver de registrar/editar
    }

    private fun mostrarUsuarios() {
        RetrofitInstance.api3kotlin.getUsuarios().enqueue(object : Callback<List<Usuario>> {
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (!data.isNullOrEmpty()) {
                        usuarios = data.toMutableList()
                        adapter = UsuarioAdapter(
                            usuarios,
                            onEliminar = { usuario, position -> confirmarYEliminar(usuario, position) },
                            onEditar = { usuario -> /* aquí aún no tenías lo de editar */ }
                        )
                        rUsuario.adapter = adapter
                    } else {
                        usuarios.clear()
                        rUsuario.adapter = UsuarioAdapter(usuarios, { _, _ -> }, { _ -> })
                        Toast.makeText(this@UsuarioActivity, "No hay usuarios disponibles", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@UsuarioActivity, "Error en la respuesta de la API", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                Toast.makeText(this@UsuarioActivity, "Error de conexión con la API", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun confirmarYEliminar(usuario: Usuario, position: Int) {
        val nombre = usuario.nombres ?: ""
        AlertDialog.Builder(this)
            .setTitle("Eliminar usuario")
            .setMessage("¿Estás seguro de eliminar a $nombre?")
            .setPositiveButton("Sí") { _, _ -> eliminarUsuario(usuario, position) }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun eliminarUsuario(usuario: Usuario, position: Int) {
        val numDoc = usuario.numDoc
        if (numDoc.isEmpty()) {
            Toast.makeText(this, "numDoc inválido", Toast.LENGTH_SHORT).show()
            return
        }

        RetrofitInstance.api3kotlin.deleteUsuario(numDoc)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@UsuarioActivity, "Usuario eliminado", Toast.LENGTH_SHORT).show()
                        adapter.eliminarUsuarioDeLista(position)
                    } else {
                        Toast.makeText(this@UsuarioActivity, "Error al eliminar: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@UsuarioActivity, "Error de red: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
