package com.example.BEJI.Subcategoria
import com.example.BEJI.Categorias.Categorias
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.RowMapper
@Service
class SubcategoriasServise {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate
    var mapRow = RowMapper{rs,_ -> Subcategorias(
        rs.getInt("id_sub"),
        rs.getString("nom_sub"),
      rs.getInt("cat_sub")
    ) }
    fun obtenerSubcategorias(): List<Subcategorias>{
        val consulta ="SELECT * FROM subcategoria"
        return jdbcTemplate.query(consulta,mapRow)
    }
    fun obtenerSubcategoriasPorCategoria(id: Int): List<Subcategorias>{
        val consulta ="SELECT * FROM subcategoria WHERE cat_sub= ?"
        return jdbcTemplate.query(consulta,mapRow,id)
    }
    fun crearSubcategoria(subcategorias: Subcategorias): Int{
        val incercion = "INSERT INTO subcategoria(nom_sub,cat_sub,created_at)VALUES(?,?,NOW())"
        return jdbcTemplate.update(incercion,

            subcategorias.getnom_sub(),
            subcategorias.getcat_sub()
            )
    }
    fun actualizarSubcategoria(id: Int,subcategorias: Subcategorias): Int{
        val actualizacion = "UPDATE subcategoria SET nom_sub=?, cat_sub=?, updated_at=NOW() WHERE id_sub=?"
        return jdbcTemplate.update(actualizacion,

            subcategorias.getnom_sub(),
            subcategorias.getcat_sub(),
            id
            )
    }
    fun eliminarSubcategoria(id: Int): Int{
        val eliminar = "DELETE FROM subcategoria WHERE id_sub=?"
        return jdbcTemplate.update(eliminar,id)
    }
}