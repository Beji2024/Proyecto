package com.example.BEJI.Estado_pedido
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estadoPedido")
class EstadoPedidoController {
    @Autowired
    lateinit var service: EstadoPedidoService

    @GetMapping
    fun obtenerEstadoPedido():List<EstadoPedido>{
        return service.obtenerEstadoPedido()
    }
    @GetMapping("{id}")
    fun obtenerEstadopedidoId(@PathVariable id : Int): EstadoPedido?{
        return service.obtenerEstadoPedidoId(id)
    }
    @PostMapping
    fun registrarEstadoPedido(@RequestBody estadoPedido: EstadoPedido): String{
        var resultado = service.registrarEstadoPedido(estadoPedido)
        if(resultado>0){
            return "El registro se realizo correctamente"
        }
        else{
            return "Registro no realizado"
        }
    }
    @PutMapping("/{id}")
    fun actualizarEstadoPedido(@RequestBody estadoPedido: EstadoPedido,@PathVariable id: Int):String{
        var resultado = service.actualizarEstadoPedido(estadoPedido,id)
        return if(resultado > 0){
            "Registro actualizado correctamente"
        }
        else{"Registro no encontrado"}
    }
    @DeleteMapping("/{id}")
    fun eliminarEstadoPedido(@PathVariable id: Int):String{
        var resultado = service.eliminarEstdoPedido(id)
        return if(resultado>0){
            "Registro eliminado sin problema"
        }
        else{
            "Registro no encontrado"
        }
    }
}