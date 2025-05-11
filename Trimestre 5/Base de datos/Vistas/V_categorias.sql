CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_categorias` AS
    SELECT 
        `c`.`idcat` AS `idcat`, `c`.`nom_cat` AS `nom_cat`
    FROM
        `categoria` `c`