#language: es
#author: Juan Martinez

Característica: Eliminar un producto en la página web de Sport10
  Como administrador de la página web
  Quiero eliminar productos en la página web
  Para mantener actualizado el inventario y retirar los productos que ya no estén disponibles

  Antecedentes:
    Dado que el administrador esté en el módulo de productos con las credenciales:
      | email            | password |
      | felipe@gmail.com | 123456   |

  @EliminarProductos
  Escenario: Eliminar el último producto registrado correctamente
    Cuando el administrador elimine el último producto de la lista
    Entonces el producto debe desaparecer de la lista de productos
