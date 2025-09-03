package com.example.BEJI.Proveedor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.RowMapper

@Service
class ProveedorService {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate


    fun obtenerproveedor():List<Proveedor>{
        val sql = "SELECT * FROM proveedor"
        return jdbcTemplate.query(sql, RowMapper{ rs, _->
            Proveedor(
                rs.getInt("id"),
            rs.getString("nombre"),
            rs.getString("nit"),
            rs.getString("celular"),
            rs.getString("email"),
            rs.getString("direccion")
        )})
    }

    fun obtenerproveedorId(id:Int):Proveedor?{
        val sql = "SELECT * FROM proveedor WHERE id = ?"
        return jdbcTemplate.queryForObject(sql, RowMapper{ rs, _->
            Proveedor(
                rs.getInt("id"),
            rs.getString("nombre"),
            rs.getString("nit"),
            rs.getString("celular"),
            rs.getString("email"),
            rs.getString("direccion"),
        )},id)
    }
    fun obtenerproveedorNit(nit: String): Proveedor?{
        val sql = "SELECT * FROM proveedor WHERE nit = ?"
        return jdbcTemplate.queryForObject(sql, RowMapper{rs,_->
            Proveedor(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("nit"),
                rs.getString("celular"),
                rs.getString("email"),
                rs.getString("direccion"),
            )
        },nit)
    }

    fun registrarProveedor(proveedor: Proveedor): Int{
        val sql = "INSERT INTO proveedor(nombre,nit,celular,email,direccion,created_at)VALUES(?,?,?,?,?,NOW())"
        return jdbcTemplate.update(sql,
            proveedor.getNombre(),
            proveedor.getNit(),
            proveedor.getCelular(),
            proveedor.getEmail(),
            proveedor.getDireccion())
    }

    fun actualizarProveedor(id:Int, proveedor: Proveedor): Int{
        val sql = "UPDATE proveedor SET nombre=?,nit=?,celular=?,email=?,direccion=?,updated_at=NOW() WHERE id =?"
        return jdbcTemplate.update(sql,
            proveedor.getNombre(),
            proveedor.getNit(),
            proveedor.getCelular(),
            proveedor.getEmail(),
            proveedor.getDireccion(),id)
    }
    fun eliminarProveedor(id:Int): Int{
        val sql = "Delete from proveedor where id=?"
        return jdbcTemplate.update(sql,id)
    }

}