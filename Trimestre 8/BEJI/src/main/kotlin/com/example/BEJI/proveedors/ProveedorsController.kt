package com.example.BEJI.proveedors
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
class ProveedorsController {
    @Autowired
    lateinit var proveedorsService: ProveedorsService

    @GetMapping("/proveedores")

    fun obtenerProveedors():List<Proveedors>{
        return proveedorsService.obtenerproveedors()
    }
    @GetMapping("/proveedores/{id}")
    fun obtenerproveedorsId(@PathVariable id : Int): List<Proveedors>{
        return proveedorsService.obtenerproveedorsId(id)
    }

    @PostMapping("/registrar")
    fun registrarProveedors(@RequestBody proveedors: Proveedors): String{
        var resultado = proveedorsService.registrarProveedors(proveedors)
        if(resultado>0){
            return "Usuario registrado sin problemas"
        }
        else{
            return "Ocurrio un problema, usuario no registado"
        }
    }
    @PutMapping("/actualizar/{id}")
    fun actualizarProveedors(@PathVariable id:Int,@RequestBody proveedors: Proveedors):String{
        var resultado = proveedorsService.actualizarProveedors(id,proveedors)
        if(resultado>0){
            return "Usuario actualizado con exito"
        }else{
            return "Usuario no encontrado"
        }

    }
    @DeleteMapping("/eliminar/{id}")
    fun eliminarProveedors(@PathVariable id:Int): String{
        var resultado = proveedorsService.eliminarProveedors(id)
        if(resultado>0){
            return "Usuario eliminado correctamente"
        }
        else{
            return "Usuario no encontrado"
        }
    }

}

