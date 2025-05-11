DELIMITER $$
CREATE PROCEDURE PA_crear_Subcategoria(
    IN p_nom_sub VARCHAR(45),
    IN p_cat_sub INT
)
BEGIN
    INSERT INTO subcategoria (nom_sub, cat_sub)
    VALUES (p_nom_sub, p_cat_sub);
END$$
DELIMITER ;