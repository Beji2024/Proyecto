#language: es
  #author: Felipe Mosquera

  Característica: Editar un usuario en pagina web de Sport10
    Como administrador de la pagina web
    Quiero editar usuarios en la pagina web
    Para modificar los datos de los usuarios que desee

    Antecedentes:
      Dado que el administrador este en la pagina
      Cuando ingrese las crendenciales para loguearse:
        | email            | password             |
        | felipe@gmail.com | skjdahkjshdu13432.,- |
        |                  |                      |
      Entonces Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones


    @EditarUsuarios

    Escenario: Verificar la modificacion exitosa de datos de un usuario
      Dado que el usuario se encuentre en la pagina en el modulo de usuarios para editar
      Cuando ingrese los datos que desee modificar para editar el registro:
        | nombres  | apellidos | direccion       | num_tel    |
        | Probando | Lopez     | Calle 63 #32-23 | 3109875434 |
      Entonces Se debe verificar que los datos modificados del usuario esten en el nuevo registro