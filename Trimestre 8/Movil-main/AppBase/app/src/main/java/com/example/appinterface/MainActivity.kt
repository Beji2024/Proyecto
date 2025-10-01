package com.example.appinterface

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.annotation.SuppressLint
import android.content.Intent
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.Adapter.PersonaAdapter
import com.example.appinterface.Api.DataResponse
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.Usuario.UsuarioActivity
import com.example.appinterface.proveedor.ProveedoresActivity
import com.google.android.material.appbar.MaterialToolbar
import androidx.cardview.widget.CardView
import com.example.appinterface.venta.VentasActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val cardProveedores = findViewById<CardView>(R.id.cardProveedores)
        cardProveedores.setOnClickListener {
            val intent = Intent(this, ProveedoresActivity::class.java)
            startActivity(intent)
        }

        val cardUsuarios = findViewById<CardView>(R.id.cardUsuarios)
        cardUsuarios.setOnClickListener {
            val intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
        }

        val cardClientes = findViewById<CardView>(R.id.cardClientes)
        cardClientes.setOnClickListener {
            val intent = Intent(this, VentasActivity::class.java)
            startActivity(intent)
        }
    }
}