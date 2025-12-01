#language: es
#author: Matrucs

Característica: Consultar ventas en la página Sport10
  Como administrador de Sport10
  Quiero consultar las ventas registradas
  Para verificar que la información esté disponible correctamente

  @ConsultarVenta
  Escenario: Validar que el administrador pueda consultar las ventas
    Dado que el administrador este en la pagina
    Cuando ingrese las crendenciales para loguearse:
      | email            | password             |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Y el administrador hace click en Venta
    Y el administrador hace click en Consultar venta
    Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones
