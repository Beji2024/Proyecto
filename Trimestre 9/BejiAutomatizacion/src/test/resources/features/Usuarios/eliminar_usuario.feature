#language: es
  #author: Felipe Mosquera

  Característica: Eliminar un usuario en pagina web de Sport10
    Como administrador de la pagina web
    Quiero registrar usuarios en la pagina web
    Para dejar registro de los usuarios que desee

    Antecedentes:
      Dado que el administrador este en la pagina
      Cuando ingrese las crendenciales para loguearse:
        | email            | password             |
        | felipe@gmail.com | skjdahkjshdu13432.,- |
      Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones

    @EliminarUsuarios

      Escenario: Verificar que se elimina el usuario
        Dado que el usuario se encuentre en la pagina en el modulo de usuarios
        Cuando de en el boton de eliminar y confirme la accion
        Entonces Se debe verificar que el usuario se hay eliminado de la pagina web