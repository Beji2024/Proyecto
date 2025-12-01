#language: es
#author: Matrucs

Característica: Ingresar a la sección de Venta en Sport10
  Como administrador de Sport10
  Quiero ingresar al módulo de Venta
  Para continuar con el flujo de cambios

  @IngresarVenta
  Escenario: Validar que el administrador pueda ingresar a la sección de Venta
    Dado que el administrador este en la pagina
    Cuando ingrese las crendenciales para loguearse:
      | email            | password             |
      | felipe@gmail.com | skjdahkjshdu13432.,- |
    Y el administrador ingresa al módulo de cambios
    Y el administrador hace clic en el botón Cambios
    Y el administrador ingresa al módulo de devoluciones

