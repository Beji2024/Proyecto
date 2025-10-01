package com.example.BEJI.Proveedor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/proveedores")
class ProveedorController {
    @Autowired
    lateinit var servicio: ProveedorService

    @GetMapping
    fun obtenerProveedor():List<Proveedor>{
        return servicio.obtenerproveedor()
    }

    @GetMapping("/{id}")
    fun obtenerproveedorId(@PathVariable id : Int): Proveedor?{
        return servicio.obtenerproveedorId(id)
    }

    @GetMapping("/nit/{nit}")
    fun obtenerproveedorNit(@PathVariable nit:String): Proveedor?{
        return servicio.obtenerproveedorNit(nit)
    }

    @PostMapping
    fun registrarProveedor(@RequestBody proveedor: Proveedor): String{
        var resultado = servicio.registrarProveedor(proveedor)
        if(resultado>0){
            return "Usuario registrado sin problemas"
        }
        else{
            return "Ocurrio un problema, usuario no registado"
        }
    }

    @PutMapping("/{id}")
    fun actualizarProveedor(@PathVariable id:Int,@RequestBody proveedor: Proveedor):String{
        var resultado = servicio.actualizarProveedor(id,proveedor)
        if(resultado>0){
            return "Usuario actualizado con exito"
        }else{
            return "Usuario no encontrado"
        }
    }

    @DeleteMapping("/{id}")
    fun eliminarProveedor(@PathVariable id:Int): String{
        var resultado = servicio.eliminarProveedor(id)
        if(resultado>0){
            return "Usuario eliminado correctamente"
        }
        else{
            return "Usuario no encontrado"
        }
    }
}

