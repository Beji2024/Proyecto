package com.example.BEJI.venta

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class VentaService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun obtenerVentas(): List<Array<String>> {
        val sql = "SELECT * FROM venta"
        return jdbcTemplate.query(sql) { rs, _ ->
            arrayOf(
                rs.getString("nombre_cli"),
                rs.getString("direccion_cli"),
                rs.getString("correo_cli"),
                rs.getString("num_tel_cli"),
                rs.getString("num_doc_cli"),
                rs.getString("producto_id"),
                rs.getString("cantidad"),
                rs.getString("vendedor_id"),
                rs.getString("fecha"),
                rs.getString("estado_id")
            )
        }
    }

    fun registrarVenta(venta: Venta): Int {
        val sql = """
            INSERT INTO venta(nombre_cli, direccion_cli, correo_cli, num_tel_cli, num_doc_cli,
                              producto_id, cantidad, vendedor_id, fecha, created_at, estado_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW(), ?)
        """
        return jdbcTemplate.update(
            sql,
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

    fun actualizarVenta(id: Int, venta: Venta): Int {
        val sql = """
            UPDATE venta SET nombre_cli=?, direccion_cli=?, correo_cli=?, num_tel_cli=?, num_doc_cli=?,
                             producto_id=?, cantidad=?, vendedor_id=?, estado_id=?, updated_at=NOW()
            WHERE id=?
        """
        return jdbcTemplate.update(
            sql,
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
