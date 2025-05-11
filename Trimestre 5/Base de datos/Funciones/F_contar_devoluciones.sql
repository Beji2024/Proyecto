CREATE DEFINER=`root`@`localhost` FUNCTION `contar_devoluciones`(fecha_inicio DATE, fecha_fin DATE) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE total_devoluciones INT;

    SELECT COUNT(*) INTO total_devoluciones
    FROM devoluciones
    WHERE fecha BETWEEN fecha_inicio AND fecha_fin;
RETURN total_devoluciones;
END