#language: es
#author: Matrucs

Característica: Ingresar a la sección de Venta en Sport10
  Como administrador de Sport10
  Quiero ingresar al módulo de Venta
  Para continuar con el flujo de cambios
  Antecedentes:
    Dado que el administrador esté en el módulo principal con las credenciales de administrador:
      | email            | password             |
      | felipe@gmail.com | skjdahkjshdu13432.,- |

  @Cambiarventa
  Escenario: Hacer el cambio exitosamente
    Cuando el administrador realice el cambio ha devuelto
    Entonces El cambio se debe reflejar como Cambio de producto




