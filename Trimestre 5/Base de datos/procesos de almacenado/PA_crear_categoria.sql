DELIMITER $$
CREATE PROCEDURE PA_crear_categoria(IN idcat INT,IN nom_cat VARCHAR(25))
BEGIN
        INSERT INTO categoria (idcat,nom_cat) 
        VALUES (idcat,nom_cat);
END$$
DELIMITER ;