package com.example.demo
import com.example.demoimport.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")  // mejor tener un path base
class ConexionController {
    @Autowired
    lateinit var conexionServer: ConexionServer

    @GetMapping
    fun obtenerUsuarios(): List<Usuario> {
        return conexionServer.obtenerUsuarios()
    }

    @PostMapping
    fun agregarUsuario(@RequestBody usuario: Usuario): String {
        val filas = conexionServer.agregarUsuario(usuario)
        return if (filas > 0) {
            "Persona agregada correctamente"
        } else {
            "Error al agregar"
        }
    }

    @PutMapping("/{numDoc}")
    fun actualizarPersona(
        @PathVariable numDoc: String,
        @RequestBody usuario: Usuario
    ): String {
        val filas = conexionServer.actualizarPersona(numDoc , usuario)
        return if (filas > 0) {
            "Persona actualizada correctamente"
        } else {
            "No se encontró la persona con id $numDoc"
        }
    }

    @DeleteMapping("/{numDoc}")
    fun eliminarPersona(@PathVariable numDoc: String,): String {
        val filas = conexionServer.eliminarPersona(numDoc)
        return if (filas > 0) {
            "Persona eliminada correctamente"
        } else {
            "No se encontró la persona con id $numDoc"
        }
    }
}
