package com.example.BEJI.Categorias
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
@Service
class CategoriasService {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun obtenerCategorias(): List<Map<String, String>>{
        val consulta = "SELECT * FROM categorias"
        return jdbcTemplate.query(consulta,{rs, _->
            mapOf(
           "Id" to rs.getString("id"),
            "Nombre" to rs.getString("name")
        )})
    }
    fun registrarCategoria(categorias: Categorias): Int{
        val incercion = "INSERT INTO categorias(name,created_at)Values(?,NOW())"
        return jdbcTemplate.update (incercion, categorias.getName())
    }
    fun actualizarCategoria(id: Int,categorias: Categorias): Int{
        val actualizacion = "UPDATE categorias SET name=?,updated_at=NOW() WHERE id =?"
        return jdbcTemplate.update(actualizacion,categorias.getName(), id)
    }
    fun eliminarCategoria(id: Int): Int{
        val eliminar = "DELETE FROM categorias WHERE id=?"
        return jdbcTemplate.update(eliminar,id)
    }
}