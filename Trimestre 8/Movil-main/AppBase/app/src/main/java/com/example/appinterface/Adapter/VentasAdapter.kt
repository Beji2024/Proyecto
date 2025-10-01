package com.example.appinterface.venta


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appinterface.R

class VentasAdapter(
    private var ventas: List<Ventas>,
    private val onEditar: (Ventas) -> Unit,
    private val onEliminar: (Ventas) -> Unit
) : RecyclerView.Adapter<VentasAdapter.VentaViewHolder>() {

    class VentaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCliente: TextView = itemView.findViewById(R.id.tvCliente)
        val tvCorreo: TextView = itemView.findViewById(R.id.tvCorreo)
        val tvCantidad: TextView = itemView.findViewById(R.id.tvCantidad)
        val tvProductoId: TextView = itemView.findViewById(R.id.tvProductoId)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditar)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VentaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_venta, parent, false)
        return VentaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VentaViewHolder, position: Int) {
        val venta = ventas[position]


        holder.tvCliente.text = "Cliente: ${venta.nombreCli}"
        holder.tvCorreo.text = "Correo: ${venta.correoCli}"
        holder.tvCantidad.text = "Cantidad: ${venta.cantidad}"
        holder.tvProductoId.text = "Producto ID: ${venta.productoId}"


        holder.btnEditar.setOnClickListener { onEditar(venta) }
        holder.btnEliminar.setOnClickListener { onEliminar(venta) }
    }

    override fun getItemCount(): Int = ventas.size

    fun updateData(nuevaLista: List<Ventas>) {
        ventas = nuevaLista
        notifyDataSetChanged()
    }
}
