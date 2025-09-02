package com.example.BEJI.Productos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
@Service
class ProductosService{
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun obtenerProductos(): List<Map<String, Any>>{
        val consulta ="SELECT * FROM mercancia"
        return jdbcTemplate.query(consulta,{rs, _->
            mapOf(
                "id_pro" to rs.getInt("id_pro"),
                "cantidad" to rs.getInt("cantidad"),
                "nombre" to rs.getString("nombre"),
                "talla" to rs.getInt("talla"),
                "precio_venta" to rs.getInt("precio_venta"),
                "precio_compra" to rs.getInt("precio_compra"),
                "material" to rs.getString("material"),
                "color" to rs.getString("color"),
                "imagen" to rs.getString("imagen"),
                "sub_mer" to rs.getInt("sub_mer")

            )
        })
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