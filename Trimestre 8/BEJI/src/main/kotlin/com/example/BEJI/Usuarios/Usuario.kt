package com.example.demoimport
import java.time.LocalDate
import java.time.LocalDateTime

class Usuario(
    private var id: Int? = null,
    private var numDoc: String,
    private var nombres: String,
    private var apellidos: String,
    private var direccion: String,
    private var email: String,
    private var numTel: String,
    private var fecNac: LocalDate,
    private var password: String,
    private var tipodocId: Long,
    private var rolId: Long,
    private var createdAt: LocalDateTime? = null,
    private var updatedAt: LocalDateTime? = null
) {
    fun getId(): Int? = this.id
    fun getNumDoc(): String = this.numDoc
    fun getNombres(): String = this.nombres
    fun getApellidos(): String = this.apellidos
    fun getDireccion(): String = this.direccion
    fun getEmail(): String = this.email
    fun getNumTel(): String = this.numTel
    fun getFecNac(): LocalDate = this.fecNac
    fun getPassword(): String = this.password
    fun getTipodocId(): Long = this.tipodocId
    fun getRolId(): Long = this.rolId
    fun getCreatedAt(): LocalDateTime? = this.createdAt
    fun getUpdatedAt(): LocalDateTime? = this.updatedAt

    // Setters
    fun setNumDoc(numDoc: String) { this.numDoc = numDoc.trim() }
    fun setNombres(nombres: String) { this.nombres = nombres.trim() }
    fun setApellidos(apellidos: String) { this.apellidos = apellidos.trim() }
    fun setDireccion(direccion: String) { this.direccion = direccion.trim() }
    fun setEmail(email: String) {
        if (!email.contains("@")) throw IllegalArgumentException("Email inválido")
        this.email = email.trim().lowercase()
    }
    fun setNumTel(numTel: String) {
        if (numTel.length < 10) throw IllegalArgumentException("Número telefónico inválido")
        this.numTel = numTel.trim()
    }
    fun setFecNac(fecNac: LocalDate) { this.fecNac = fecNac }
    fun setPassword(password: String) {
        if (password.length < 6) throw IllegalArgumentException("La contraseña debe tener al menos 6 caracteres")
        this.password = password
    }
    fun setTipodocId(tipodocId: Long) { this.tipodocId = tipodocId }
    fun setRolId(rolId: Long) { this.rolId = rolId }


}

