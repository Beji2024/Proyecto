DELIMITER $$
CREATE TRIGGER T_verificar_Subcategoria_duplicada
BEFORE INSERT ON subcategoria
FOR EACH ROW
BEGIN

    IF EXISTS (SELECT 1 FROM subcategoria WHERE nom_sub = NEW.nom_sub AND cat_sub = NEW.cat_sub) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La subcategoría con ese id ya existe.';
    END IF;
END$$
DELIMITER ;
