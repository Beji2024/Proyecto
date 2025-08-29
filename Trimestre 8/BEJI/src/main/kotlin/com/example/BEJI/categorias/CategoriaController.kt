package com.example.BEJI.categorias
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoriaController {
    @Autowired
    lateinit var categoriasService: CategoriasService
    @GetMapping("/categorias")
    fun obtenerCategorias(): List<Map<String, String>>{
        return categoriasService.obtenerCategorias()

    }
    @PostMapping("/categorias")
    fun registrarCategorias(@RequestBody categorias: Categorias): String{
        var resultado = categoriasService.registrarCategoria(categorias)
        if(resultado>0){
            return "Categoria creada con exito"
        }else{
            return "Ups, no se pudo registrar la categoria"
        }
    }
    @PutMapping("categorias/{id}")
    fun actualizarCategorias(@PathVariable id:Int, @RequestBody categorias: Categorias ): String{
        var resultado = categoriasService.actualizarCategoria(id, categorias)
        if(resultado>0){
            return "La categoria se ha actualizado correctamente"
        }else{
            return "Ups, no se ha podido actualizar la categoria"
        }
    }
    @DeleteMapping("categorias/{id}")
    fun eliminarCategoria(@PathVariable id: Int): String{
        var resultado = categoriasService.eliminarCategoria(id)
        if(resultado>0){
            return "Categoria eliminada con exito"
        }else{
            return "Ups, no se pudo eliminar la categoria"
        }
    }

}
