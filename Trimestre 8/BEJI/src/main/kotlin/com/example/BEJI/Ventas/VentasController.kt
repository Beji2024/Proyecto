package com.example.BEJI.venta

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class VentaController {
    @Autowired
    lateinit var ventaService: VentaService

    @GetMapping("/ventas")
    fun obtenerVentas(): List<Array<String>> {
        return ventaService.obtenerVentas()
    }

    @PostMapping("/registrarVenta")
    fun registrarVenta(@RequestBody venta: Venta): String {
        val resultado = ventaService.registrarVenta(venta)
        return if (resultado > 0) "Venta registrada correctamente"
        else "Error al registrar la venta"
    }

    @PutMapping("/actualizarVenta/{id}")
    fun actualizarVenta(@PathVariable id: Int, @RequestBody venta: Venta): String {
        val resultado = ventaService.actualizarVenta(id, venta)
        return if (resultado > 0) "Venta actualizada correctamente"
        else "Venta no encontrada"
    }

    @DeleteMapping("/eliminarVenta/{id}")
    fun eliminarVenta(@PathVariable id: Int): String {
        val resultado = ventaService.eliminarVenta(id)
        return if (resultado > 0) "Venta eliminada correctamente"
        else "Venta no encontrada"
    }
}
