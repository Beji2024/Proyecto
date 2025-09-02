package com.example.BEJI.Productos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductosController {
    @Autowired
    lateinit var productosService: ProductosService
    @GetMapping("/productos")
    fun obtenerProductos(): List<Map<String, Any>>{
        return productosService.obtenerProductos()
    }
    @PostMapping("/productos")
    fun crearProductos(@RequestBody productos: Productos): String{
        var resultado = productosService.crearProductos(productos)
        if(resultado>0){
            return "Producto registrado con exito"
        }else{
            return "Ups, no se pudo registrar el producto"
        }
    }
    @PutMapping("/productos/{id}")
    fun actualizarProductos(@PathVariable id: Int,@RequestBody productos: Productos): String{
        var resultado = productosService.actualizarProductos(id,productos)
        if(resultado>0){
            return "El producto fue actualizado con exito"
        }else{
            return "Ups, no se ha pudo actualizar el producto"
        }
    }
    @DeleteMapping("/productos/{id}")
    fun eliminarProducto(@PathVariable id: Int): String{
        var resultado = productosService.eliminarProducto(id)
        if(resultado>0){
            return "El producto fue eliminado con exito"
        }else{
            return "El producto nose pudo eliminar"
        }
    }

}