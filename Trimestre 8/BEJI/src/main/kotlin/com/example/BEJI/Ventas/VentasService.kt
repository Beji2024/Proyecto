package com.example.BEJI.venta

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class VentasService {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun obtenerVentas(): List<Ventas> {
        val sql = "SELECT * FROM venta"
        return jdbcTemplate.query(sql) { rs, _ -> Ventas(
            rs.getString("nombre_cli"),
            rs.getString("direccion_cli"),
            rs.getString("correo_cli"),
            rs.getString("num_tel_cli"),
            rs.getString("num_doc_cli"),
            rs.getLong("producto_id"),
            rs.getInt("cantidad"),
            rs.getLong("vendedor_id"),
            rs.getLong("estado_id")
        )}
    }

    fun registrarVenta(venta: Ventas): Int {
        val sql = """
            INSERT INTO venta (nombre_cli, direccion_cli, correo_cli, num_tel_cli, num_doc_cli, producto_id, cantidad, vendedor_id, estado_id, created_at) 
            VALUES (?,?,?,?,?,?,?,?,?,NOW())
        """
        return jdbcTemplate.update(sql,
            venta.getNombreCli(),
            venta.getDireccionCli(),
            venta.getCorreoCli(),
            venta.getNumTelCli(),
            venta.getNumDocCli(),
            venta.getProductoId(),
            venta.getCantidad(),
            venta.getVendedorId(),
            venta.getEstadoId()
        )
    }

    fun actualizarVenta(id: Int, venta: Ventas): Int {
        val sql = """
            UPDATE venta SET nombre_cli=?, direccion_cli=?, correo_cli=?, num_tel_cli=?, num_doc_cli=?, producto_id=?, cantidad=?, vendedor_id=?, estado_id=?, updated_at=NOW()
            WHERE id=?
        """
        return jdbcTemplate.update(sql,
            venta.getNombreCli(),
            venta.getDireccionCli(),
            venta.getCorreoCli(),
            venta.getNumTelCli(),
            venta.getNumDocCli(),
            venta.getProductoId(),
            venta.getCantidad(),
            venta.getVendedorId(),
            venta.getEstadoId(),
            id
        )
    }


    fun eliminarVenta(id: Int): Int {
        val sql = "DELETE FROM venta WHERE id=?"
        return jdbcTemplate.update(sql, id)
    }
}
