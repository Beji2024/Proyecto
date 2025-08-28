package com.example.BEJI.Usuarios
import com.example.demoimport.Usuario
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UsuarioService {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun obtenerUsuarios(): List<Usuario> {
        val sql = "SELECT * FROM usuarios"
        return jdbcTemplate.query(sql) { rs, _ ->
            Usuario(
                id = rs.getInt("id"),
                numDoc = rs.getString("num_doc"),
                nombres = rs.getString("nombres"),
                apellidos = rs.getString("apellidos"),
                direccion = rs.getString("direccion"),
                email = rs.getString("email"),
                numTel = rs.getString("num_tel"),
                fecNac = rs.getDate("fec_nac")?.toLocalDate() ?: LocalDate.now(),
                password = rs.getString("password"),
                tipodocId = rs.getLong("tipodoc_id"),
                rolId = rs.getLong("rol_id"),
                createdAt = rs.getTimestamp("created_at")?.toLocalDateTime(),
                updatedAt = rs.getTimestamp("updated_at")?.toLocalDateTime()

            )
        }
    }

    fun obtenerUsuarioPorId(numDoc: String): Usuario? {
        val sql = "SELECT * FROM usuarios WHERE id = ?"
        return jdbcTemplate.query(sql, arrayOf(numDoc)) { rs, _ ->
            Usuario(
                id = rs.getInt("id"),
                numDoc = rs.getString("num_doc"),
                nombres = rs.getString("nombres"),
                apellidos = rs.getString("apellidos"),
                direccion = rs.getString("direccion"),
                email = rs.getString("email"),
                numTel = rs.getString("num_tel"),
                fecNac = rs.getDate("fec_nac")?.toLocalDate() ?: LocalDate.now(),
                password = rs.getString("password"),
                tipodocId = rs.getLong("tipodoc_id"),
                rolId = rs.getLong("rol_id")
            )
        }.firstOrNull()
    }


    fun agregarUsuario(usuario: Usuario): Int {
        val passwordCifrada = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt())
        val sql = """
            INSERT INTO usuarios (
                num_doc, nombres, apellidos, direccion, email, num_tel, fec_nac, password, tipodoc_id, rol_id, created_at, updated_at
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())
        """.trimIndent()
        return jdbcTemplate.update(
            sql,
            usuario.getNumDoc(),
            usuario.getNombres(),
            usuario.getApellidos(),
            usuario.getDireccion(),
            usuario.getEmail(),
            usuario.getNumTel(),
            usuario.getFecNac(),
            passwordCifrada,
            usuario.getTipodocId(),
            usuario.getRolId()
        )
    }

    fun actualizarPersona(numDoc: String, usuario: Usuario): Int {
        val sql = """
            UPDATE usuarios SET 
                num_doc = ?, nombres = ?, apellidos = ?, direccion = ?, email = ?, num_tel = ?, 
                fec_nac = ?, password = ?, tipodoc_id = ?, rol_id = ? 
            WHERE num_doc = ?
        """.trimIndent()
        return jdbcTemplate.update(
            sql,
            usuario.getNumDoc(),
            usuario.getNombres(),
            usuario.getApellidos(),
            usuario.getDireccion(),
            usuario.getEmail(),
            usuario.getNumTel(),
            usuario.getFecNac(),
            usuario.getPassword(),
            usuario.getTipodocId(),
            usuario.getRolId(),
            numDoc
        )
    }

    fun eliminarPersona(numDoc: String): Int {
        val sql = "DELETE FROM usuarios WHERE num_doc = ?"
        return jdbcTemplate.update(sql, numDoc)
    }
}
