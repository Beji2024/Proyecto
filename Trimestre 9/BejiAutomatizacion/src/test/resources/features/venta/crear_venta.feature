#language: es
#author: Matrucs

Característica: Registrar ventas en la página Sport10
  Como administrador de Sport10
  Quiero crear una nueva venta
  Para almacenarla correctamente en el sistema

  @CrearVenta
  Escenario: Validar la creación exitosa de una venta
    Dado que el administrador este en la pagina
    Cuando ingrese las crendenciales para loguearse:
      | email            | password             |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Y el administrador hace click en Venta
    Y el administrador hace click en Crear venta
    Y el administrador llena el formulario de venta:
      | nombre_cli   | direccion_cli | correo_cli     | num_tel_cli | num_doc_cli | referencia | cantidad | vendedor |
      | Mateo Garcia | Calle 100     | mateo@test.com | 3015551111  | 123456789   | 1          | 2        | 2        |
    Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones
