#language: es
#author: Matrucs

Característica: Registrar ventas en la página Sport10
  Como administrador de Sport10
  Quiero crear una nueva venta
  Para almacenarla correctamente en el sistema

  Antecedentes:
    Dado que el administrador esté en el módulo de ventas con las credenciales:
      | email            | password |
      | felipe@gmail.com | skjdahkjshdu13432.,-   |

  @CrearVenta
  Escenario: Crear exitosamente una venta
    Cuando el administrador este en el modulo de venta debe registrar una venta con los siguientes datos:
      | nombre_cli   | direccion_cli | correo_cli     | num_tel_cli | num_doc_cli | referencia | cantidad | vendedor |
      | Mateo Garcia | Calle 100     | mateo@test.com | 3015551111  | 123456789   | 1          | 2        | 2        |
    Entonces la venta debe quedar registrada correctamente
