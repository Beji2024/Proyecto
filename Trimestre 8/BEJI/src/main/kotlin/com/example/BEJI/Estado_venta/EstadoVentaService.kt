package com.example.BEJI.Estado_venta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service


@Service
class EstadoVentaService {
    @Autowired
    lateinit var consultaMysql: JdbcTemplate
    fun obtenerEstadoVenta():List<EstadoVenta>{
        val sql= "SELECT * FROM estado_venta"
        return consultaMysql.query(sql, {rs, _ -> EstadoVenta(
            rs.getInt("id"),
            rs.getString("nombre")
        )})
    }
    fun obtenerEstadoVentaId(id: Int): EstadoVenta?{
        val sql= "SELECT * FROM estado_venta WHERE id=?"
        return consultaMysql.queryForObject(sql,{rs, _-> EstadoVenta(
            rs.getInt("id"),
            rs.getString("nombre")
        )},id)
    }
    fun registrarEstadoVenta( estadoVenta: EstadoVenta):Int{
        val sql = "INSERT INTO estado_venta(nombre, created_at) Values(?,NOW())"
        return consultaMysql.update(sql, estadoVenta.getNombre())
    }
    fun actualizarEstadoVenta(estadoVenta: EstadoVenta, id: Int): Int{
        val sql = "UPDATE estado_venta SET nombre = ?, updated_at = NOW() WHERE id=?"
        return consultaMysql.update(sql, estadoVenta.getNombre(), id)
    }
    fun eliminarEstadoVenta(id: Int): Int{
        val sql = "DELETE FROM estado_venta WHERE id=?"
        return consultaMysql.update(sql,id)
    }
}