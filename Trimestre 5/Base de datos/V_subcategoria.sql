CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_subcategorias` AS
    SELECT 
        `s`.`id_sub` AS `id_sub`,
        `s`.`nom_sub` AS `nom_sub`,
        `s`.`cat_sub` AS `cat_sub`,
        `c`.`nom_cat` AS `nombre_categoria`
    FROM
        (`subcategoria` `s`
        LEFT JOIN `categoria` `c` ON (`s`.`cat_sub` = `c`.`idcat`))