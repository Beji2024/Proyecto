package com.example.BEJI.Proveedor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/proveedores")
class ProveedorController {
    @Autowired
    lateinit var proveedorService: ProveedorService

    @GetMapping
    fun obtenerProveedor():List<Proveedor>{
        return proveedorService.obtenerproveedor()
    }

    @GetMapping("/{id}")
    fun obtenerproveedorId(@PathVariable id : Int): Proveedor?{
        return proveedorService.obtenerproveedorId(id)
    }

    @PostMapping
    fun registrarProveedor(@RequestBody proveedor: Proveedor): String{
        var resultado = proveedorService.registrarProveedor(proveedor)
        if(resultado>0){
            return "Usuario registrado sin problemas"
        }
        else{
            return "Ocurrio un problema, usuario no registado"
        }
    }

    @PutMapping("/{id}")
    fun actualizarProveedor(@PathVariable id:Int,@RequestBody proveedor: Proveedor):String{
        var resultado = proveedorService.actualizarProveedor(id,proveedor)
        if(resultado>0){
            return "Usuario actualizado con exito"
        }else{
            return "Usuario no encontrado"
        }
    }

    @DeleteMapping("/{id}")
    fun eliminarProveedor(@PathVariable id:Int): String{
        var resultado = proveedorService.eliminarProveedor(id)
        if(resultado>0){
            return "Usuario eliminado correctamente"
        }
        else{
            return "Usuario no encontrado"
        }
    }
}

