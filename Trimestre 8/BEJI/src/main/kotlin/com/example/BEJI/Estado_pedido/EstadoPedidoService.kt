package com.example.BEJI.Estado_pedido
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class EstadoPedidoService {
    @Autowired
    lateinit var consultaMySQL: JdbcTemplate
    fun obtenerEstadoPedido(): List<EstadoPedido>{
        val sql = "SELECT * FROM estado_pedido"
        return consultaMySQL.query(sql) {rs, _ -> EstadoPedido(
            rs.getInt("id"),
            rs.getString("nombre")
        )}
    }
    fun obtenerEstadoPedidoId(id: Int): EstadoPedido?{
        val sql = "SELECT * FROM estado_pedido WHERE id = ?"
        return consultaMySQL.queryForObject(sql, {rs, _ -> EstadoPedido(
            rs.getInt("id"),
            rs.getString("nombre")
        )},id)
    }
    fun registrarEstadoPedido(estadoPedido: EstadoPedido): Int{
        val sql = "INSERT INTO estado_pedido(nombre, created_at) VALUES (?,NOW())"
        return consultaMySQL.update(sql,
            estadoPedido.getNombre())
    }
    fun actualizarEstadoPedido(estadoPedido: EstadoPedido, id: Int): Int{
        val sql = "UPDATE estado_pedido SET nombre = ?, updated_at = NOW() WHERE id=?"
        return consultaMySQL.update(sql,estadoPedido.getNombre(),id)
    }
    fun eliminarEstdoPedido(id: Int):Int{
        val sql = "DELETE FROM estado_pedido WHERE id = ?"
        return consultaMySQL.update(sql,id)
    }
}