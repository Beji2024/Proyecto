#language: es
#author: Juan Martinez

Característica: Registrar un producto en página web de Sport10
  Como administrador de la página web
  Quiero registrar productos en la página web
  Para dejar registro de los productos que desee

  Antecedentes:
    Dado que el administrador esté en el módulo de productos con las credenciales:
      | email            | password |
      | felipe@gmail.com | skjdahkjshdu13432.,-   |

  @RegistrarProductos
  Escenario: Registrar un nuevo producto correctamente
    Cuando el administrador cree un nuevo producto con los siguientes datos:
      | nombre_producto | categoria | subcategoria | cantidad | talla | precio_venta | precio_compra | material | color  | imagen        |
      | Camisa Nike     | Hombre    | Deportivo    | 10       | 12    | 80000        | 50000         | Algodón  | Blanco | ic_Zapato.png |
    Entonces el producto con nombre Camisa Nike debe aparecer en la lista de productos
