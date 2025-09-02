package com.example.BEJI.estado_pedido
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estadoPedido")
class EstadoPedidoController {
    @Autowired
    lateinit var estadoPedidoService: EstadoPedidoService

    @GetMapping
    fun obtenerEstadoPedido():List<EstadoPedido>{
        return estadoPedidoService.obtenerEstadoPedido()
    }
    @GetMapping("{id}")
    fun obtenerEstadopedidoId(@PathVariable id : Int): EstadoPedido?{
        return estadoPedidoService.obtenerEstadoPedidoId(id)
    }
    @PostMapping
    fun registrarEstadoPedido(@RequestBody estadoPedido: EstadoPedido): String{
        var resultado = estadoPedidoService.registrarEstadoPedido(estadoPedido)
        if(resultado>0){
            return "El registro se realizo correctamente"
        }
        else{
            return "Registro no realizado"
        }
    }
    @PutMapping("/{id}")
    fun actualizarEstadoPedido(@RequestBody estadoPedido: EstadoPedido,@PathVariable id: Int):String{
        var resultado = estadoPedidoService.actualizarEstadoPedido(estadoPedido,id)
        return if(resultado > 0){
            "Usuario actualizado correctamente"
        }
        else{"Usuario no encontrado"}
    }
    @DeleteMapping("/{id}")
    fun eliminarEstadoPedido(@PathVariable id: Int):String{
        var resultado = estadoPedidoService.eliminarEstdoPedido(id)
        return if(resultado>0){
            "Usuario eliminado sin problema"
        }
        else{
            "Usuario no encontrado"
        }
    }
}