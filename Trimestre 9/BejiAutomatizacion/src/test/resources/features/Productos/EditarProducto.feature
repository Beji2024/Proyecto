#language: es
#author: Juan Martinez

<<<<<<< HEAD
Característica: Editar un producto en página web de Sport10
=======
Característica: Editar un producto en la página web de Sport10
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
  Como administrador de la página web
  Quiero editar productos en la página web
  Para modificar los datos de los productos registrados cuando sea necesario

  Antecedentes:
<<<<<<< HEAD
    Dado que el administrador este en la pagina
    Cuando ingrese las crendenciales para loguearse:
      | email            | password             |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones

  @EditarProductos

  Escenario: Verificar la modificación exitosa de un producto
    Dado que el administrador se encuentre en el módulo de productos
    Cuando seleccione el ícono del menú para desplegar las opciones
    Y seleccione la opción "Gestionar productos"
    Y visualice la tabla con los productos registrados
    Y seleccione el producto que desea editar
    Y dé clic en el botón "Editar"
    Y modifique los datos del producto en el formulario precargado:
      | nombre_producto | categoria | subcategoria | cantidad | talla | precio_venta | precio_compra | material   | color | imagen                |
      | Camiseta Adidas | Ropa      | Deportiva    | 80       | L     | 130000       | 90000         | Microfibra | Negra | camiseta_adidas.jpg   |
    Y presione el botón "Actualizar"
    Entonces se debe verificar que los datos del producto editado se muestren correctamente actualizados en la tabla de productos
=======
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
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
