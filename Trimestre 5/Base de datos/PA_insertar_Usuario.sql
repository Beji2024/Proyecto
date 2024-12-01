DELIMITER $$
CREATE PROCEDURE PA_insertar_Usuario(
    IN p_num_doc INT,
    IN p_nombres VARCHAR(50),
    IN p_apellidos VARCHAR(50),
    IN p_direccion VARCHAR(50),
    IN p_correo VARCHAR(45),
    IN p_num_tel VARCHAR(20),
    IN p_fec_nac DATE,
    IN p_t_doc INT,
    IN p_rol INT
)
BEGIN
    INSERT INTO usuario (num_doc, nombres, apellidos, direccion, correo, num_tel, fec_nac, t_doc, rol)
    VALUES (p_num_doc, p_nombres, p_apellidos, p_direccion, p_correo, p_num_tel, p_fec_nac, p_t_doc, p_rol);
END$$
DELIMITER ;