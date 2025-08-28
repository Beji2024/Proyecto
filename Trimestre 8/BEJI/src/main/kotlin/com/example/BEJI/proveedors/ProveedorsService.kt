package com.example.BEJI.proveedors
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class ProveedorsService {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun obtenerproveedors():List<Proveedors>{
        val sql = "SELECT * FROM proveedors"
        return jdbcTemplate.query(sql){rs, _->
            Proveedors(
            rs.getString("name"),
            rs.getString("direccion"),
            rs.getString("nit"),
            rs.getString("telefono"),
            rs.getString("email")
        )}
    }
    fun obtenerproveedorsId(id:Int):List<Proveedors>{
        val sql = "SELECT * FROM proveedors WHERE id = ?"
        return jdbcTemplate.query(sql, {rs, _->
            Proveedors(
            rs.getString("name"),
            rs.getString("direccion"),
            rs.getString("nit"),
            rs.getString("telefono"),
            rs.getString("email"),
        )},id)
    }
    fun registrarProveedors(proveedors: Proveedors): Int{
        val sql = "INSERT INTO proveedors(nit,name,direccion,telefono,email,created_at)VALUES(?,?,?,?,?,NOW())"
        return jdbcTemplate.update(sql,
            proveedors.getNit(),
            proveedors.getName(),
            proveedors.getDireccion(),
            proveedors.getTelefono(),
            proveedors.getEmail())
    }
    fun actualizarProveedors(id:Int, proveedors: Proveedors): Int{
        val sql = "UPDATE proveedors SET nit=?,name=?,direccion=?,telefono=?,email=?,updated_at=NOW() WHERE id =?"
        return jdbcTemplate.update(sql,
            proveedors.getNit(),
            proveedors.getName(),
            proveedors.getDireccion(),
            proveedors.getTelefono(),
            proveedors.getEmail(),id)
    }
    fun eliminarProveedors(id:Int): Int{
        val sql = "Delete from proveedors where id=?"
        return jdbcTemplate.update(sql,id)
    }

}