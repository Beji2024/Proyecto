package com.example.BEJI.estado_venta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estadoVenta")
class EstadoVentaController {
    @Autowired
    lateinit var service: EstadoVentaService
    @GetMapping
    fun obtenerEstadoVenta():List<EstadoVenta>{
        return service.obtenerEstadoVenta()
    }
    @GetMapping("/{id}")
    fun obtenerEstadoVentaId(@PathVariable id:Int): EstadoVenta?{
        return service.obtenerEstadoVentaId(id)
    }
    @PostMapping
    fun registrarEstadoVenta(@RequestBody estadoVenta: EstadoVenta): String{
        var resultado = service.registrarEstadoVenta(estadoVenta)
        return if(resultado>0){
            "Registro realizado con exito"
        }
        else{"Error al realizar el registro"
        }
    }
    @PutMapping("/{id}")
    fun actualizarEstadoVenta(@RequestBody estadoVenta: EstadoVenta, @PathVariable id : Int ): String{
        var resultado = service.actualizarEstadoVenta(estadoVenta,id)
        return if(resultado>0){
            "Registro correctamente actualizado"
        }
        else{
            "Registro no encontrado"
        }
    }
    @DeleteMapping("/{id}")
    fun eliminarEstadoVenta(@PathVariable id :Int): String{
        var resultado = service.eliminarEstadoVenta(id)
        return if(resultado>0){
            "El registro se elimino sin problemas"
        }
        else{
            "El registro no se encontro"
        }
    }
}