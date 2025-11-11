#language: es
#author: Juan Martinez

Característica: Eliminar un producto en la página web de Sport10
  Como administrador de la página web
  Quiero eliminar productos en la página web
  Para mantener actualizado el inventario y retirar los productos que ya no estén disponibles

  Antecedentes:
    Dado que el administrador este en la pagina
    Cuando ingrese las crendenciales para loguearse:
      | email            | password             |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones

  @EliminarProductos

  Escenario: Verificar la eliminación exitosa de un producto
    Dado que el administrador se encuentre en el módulo de productos
    Cuando seleccione el ícono del menú para desplegar las opciones
    Y seleccione la opción "Gestionar productos"
    Y acceda al módulo de gestión de productos
    Y visualice la tabla con la lista de productos registrados
    Y en la lista identifique el producto que desea eliminar
    Y dé clic en la opción "Eliminar" correspondiente a ese producto
    Y confirme la acción de eliminación
    Entonces se debe verificar que el producto eliminado ya no aparezca en la tabla de productos registrados
