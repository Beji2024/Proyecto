CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vista_inventario_completa` AS
    SELECT 
        `m`.`id_pro` AS `id_pro`,
        `m`.`nombre` AS `nombre`,
        `m`.`cantidad` AS `cantidad`,
        `m`.`precio_venta` AS `precio_venta`,
        `m`.`precio_compra` AS `precio_compra`,
        `sc`.`nom_sub` AS `subcategoria`,
        `c`.`nom_cat` AS `categoria`,
        `m`.`material` AS `material`,
        `m`.`color` AS `color`,
        `m`.`talla` AS `talla`
    FROM
        ((`mercancia` `m`
        LEFT JOIN `subcategoria` `sc` ON (`m`.`sub_mer` = `sc`.`id_sub`))
        LEFT JOIN `categoria` `c` ON (`sc`.`cat_sub` = `c`.`idcat`))