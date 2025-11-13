#language: es
#author: Juan Martinez

Característica: Editar un producto en la página web de Sport10
  Como administrador de la página web
  Quiero editar productos en la página web
  Para modificar los datos de los productos registrados cuando sea necesario

  Antecedentes:
    Dado que el administrador esté en el módulo de productos con las credenciales:
      | email            | password |
      | felipe@gmail.com | skjdahkjshdu13432.,-   |

  @EditarProductos
  Escenario: Editar el último producto registrado correctamente
    Cuando el administrador edite el último producto con los siguientes datos:
      | nombre_producto | categoria | subcategoria | cantidad | talla | precio_venta | precio_compra | material   | color | imagen |
      |                 |            |              |           |       |              |               |            |       |        |
    Y presione el botón "Actualizar"
    Entonces el producto editado debe mostrarse correctamente actualizado en la lista de productos
