package com.example.BEJI.Subcategoria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
@RestController
class SubcategoriasController {
    @Autowired
    lateinit var subcategoriasServise: SubcategoriasServise
    @GetMapping("/subcategorias")
    fun obtenerSubcategorias(): List<Subcategorias>{
        return subcategoriasServise.obtenerSubcategorias()
    }
    @GetMapping("/subcategorias/categorias/{id}")
    fun obtenerSubcategoriasPorCategoria(@PathVariable id: Int): List<Subcategorias>{
        return subcategoriasServise.obtenerSubcategoriasPorCategoria(id)
    }

    @PostMapping("/subcategorias")
    fun crearSubcategoria(@RequestBody subcategorias: Subcategorias): String{
        var resultado = subcategoriasServise.crearSubcategoria(subcategorias)
        if(resultado>0){
            return "Subcategoria creada con exito"
        }else{
            return "Ups, no se pudo crear la subcategoria"
        }
    }
    @PutMapping("/subcategorias/{id}")
    fun actualizarSubcategoria(@PathVariable id: Int,@RequestBody subcategorias: Subcategorias): String{
        var resultado = subcategoriasServise.actualizarSubcategoria(id,subcategorias)
        if(resultado>0){
            return "Subcategoria se a acatualizado correctamente"
        }else{
            return "Ups no se ha podido actualizar la subcategoria"
        }
    }
    @DeleteMapping("/subcategorias/{id}")
    fun eliminarSubcategoria(@PathVariable id: Int): String{
        var resultado = subcategoriasServise.eliminarSubcategoria(id)
        if(resultado>0){
            return "Subactegoria eliminada con exito"
        }else{
            return "Ups, no se pudo eliminar la subcategoria"
        }
    }
}