package com.example.appinterface.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.R
import com.example.appinterface.Usuarios.Usuario

class UsuarioAdapter(
    private val usuarios: MutableList<Usuario>,
    private val onEliminar: (Usuario, Int) -> Unit,
    private val onEditar: (Usuario) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario, onEliminar, onEditar, position)
    }

    override fun getItemCount(): Int = usuarios.size

    fun eliminarUsuarioDeLista(position: Int) {
        if (position in usuarios.indices) {
            usuarios.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, usuarios.size)
        }
    }

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        private val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        private val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)
        private val btnEditar: Button = itemView.findViewById(R.id.button2)
        private val btnEliminar: Button = itemView.findViewById(R.id.button3)

        fun bind(
            usuario: Usuario,
            onEliminar: (Usuario, Int) -> Unit,
            onEditar: (Usuario) -> Unit,
            position: Int
        ) {
            tvNombre.text = "${usuario.nombres ?: ""} ${usuario.apellidos ?: ""}".trim()
            tvEmail.text = usuario.email ?: ""
            tvTelefono.text = usuario.numTel ?: ""

            btnEditar.setOnClickListener { onEditar(usuario) }
            btnEliminar.setOnClickListener { onEliminar(usuario, position) }
        }
    }
}
