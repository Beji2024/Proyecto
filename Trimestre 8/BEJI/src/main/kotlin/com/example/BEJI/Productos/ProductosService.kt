package com.example.BEJI.Productos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.RowMapper
@Service
class ProductosService{
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate
    var mapRow = RowMapper{rs,_-> Productos(
        rs.getInt("id_pro"),
        rs.getInt("cantidad"),
        rs.getString("nombre"),
        rs.getInt("talla"),
        rs.getInt("precio_venta"),
        rs.getInt("precio_compra"),
        rs.getString("material"),
        rs.getString("color"),
        rs.getString("imagen"),
        rs.getInt("sub_mer")
    )
    }
    fun obtenerProductos(): List<Productos>{
        val consulta ="SELECT * FROM mercancia"
        return jdbcTemplate.query(consulta,mapRow)
    }
    fun obtenerProductosPorSubcategoria(id: Int): List<Productos>{
        val consulta = "SELECT * FROM mercancia WHERE sub_mer = ?"
        return jdbcTemplate.query(consulta,mapRow,id)
    }
    fun obtenerProductosPorCategoria(id: Int): List<Productos>{
        val consulta = "SELECT m.* FROM mercancia m INNER JOIN subcategoria s ON m.sub_mer = s.id_sub INNER JOIN categorias c ON s.cat_sub = c.id WHERE c.id = ?"
        return jdbcTemplate.query(consulta,mapRow,id)
    }
    fun crearProductos(productos: Productos): Int{
        val incercion = " INSERT INTO mercancia(cantidad,nombre,talla,precio_venta,precio_compra,material,color,imagen,sub_mer)values(?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(incercion,productos.getCantidad(),
            productos.getNombre(),
            productos.getTalla(),
            productos.getPrecio_venta(),
            productos.getPrecio_compra(),
            productos.getMaterial(),
            productos.getColor(),
            productos.getImagen(),
            productos.getSub_mer())
    }
    fun actualizarProductos(id: Int,productos: Productos): Int{
        val actualizacion = "UPDATE mercancia SET cantidad=?,nombre=?,talla=?,precio_venta=?,precio_compra=?,material=?,color=?,imagen=?,sub_mer=? WHERE id_pro=?"
        return jdbcTemplate.update(actualizacion,

            productos.getCantidad(),
            productos.getNombre(),
            productos.getTalla(),
            productos.getPrecio_venta(),
            productos.getPrecio_compra(),
            productos.getMaterial(),
            productos.getColor(),
            productos.getImagen(),
            productos.getSub_mer(),
            id)

    }
    fun eliminarProducto(id: Int): Int{
        var eliminar = "DELETE FROM mercancia WHERE id_pro=?"
        return jdbcTemplate.update(eliminar, id)
    }
}