DELIMITER $$

CREATE TRIGGER T_verificar_categoria_duplicada
BEFORE INSERT ON categoria
FOR EACH ROW
BEGIN
    DECLARE categoria_existe INT;

    SELECT COUNT(*) INTO categoria_existe
    FROM categoria
    WHERE nom_cat = NEW.nom_cat;

    IF categoria_existe > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La categoría ya existe.';
    END IF;
END$$
DELIMITER ;