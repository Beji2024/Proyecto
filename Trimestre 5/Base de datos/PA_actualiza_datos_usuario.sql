CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_actualizar_datos_usuario`(
    IN num_doc INT,
    IN direccion VARCHAR(50),
    IN correo VARCHAR(45),
    IN num_tel VARCHAR(20)
)
BEGIN
    -- Actualiza los campos de correo y teléfono en la tabla usuarios
    UPDATE usuarios
    SET correo = correo,
        direccion = direccion,
        telefono = num_tel
    WHERE id_usuario = num_doc;
END