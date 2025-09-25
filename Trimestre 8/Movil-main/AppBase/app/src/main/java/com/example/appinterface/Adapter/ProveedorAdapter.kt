package com.example.appinterface.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.R
import com.example.appinterface.proveedor.Proveedor

class ProveedorAdapter(
    private var proveedores: List<Proveedor>,
    private val onEditar: (Proveedor) -> Unit,
    private val onEliminar: (Proveedor) -> Unit
) : RecyclerView.Adapter<ProveedorAdapter.ProveedorViewHolder>() {

    class ProveedorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNit: TextView = itemView.findViewById(R.id.tvNit)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvDireccion: TextView = itemView.findViewById(R.id.tvDireccion)
        val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditar)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProveedorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_proveedor, parent, false)
        return ProveedorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProveedorViewHolder, position: Int) {
        val proveedor = proveedores[position]

        holder.tvNit.text = proveedor.nit
        holder.tvNombre.text = proveedor.nombre
        holder.tvDireccion.text = proveedor.direccion
        holder.tvTelefono.text = proveedor.celular
        holder.tvEmail.text = proveedor.email

        holder.btnEditar.setOnClickListener { onEditar(proveedor) }
        holder.btnEliminar.setOnClickListener { onEliminar(proveedor) }
    }

    override fun getItemCount(): Int = proveedores.size

    fun updateList(newList: List<Proveedor>) {
        proveedores = newList
        notifyDataSetChanged()
    }
}