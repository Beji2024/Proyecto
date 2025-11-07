$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/EliminarProveedor.feature");
formatter.feature({
  "name": "Eliminar proveedor",
  "description": "  Como administrador del sistema\n  Quiero eliminar un proveedor existente\n  Para mantener la base de datos actualizada",
  "keyword": "Característica"
});
formatter.scenario({
  "name": "Eliminar proveedor exitosamente",
  "description": "",
  "keyword": "Escenario",
  "tags": [
    {
      "name": "@EliminarProveedor"
    }
  ]
});
formatter.step({
  "name": "que el administrador esté en el módulo de proveedores con las credenciales:",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "felipe@gmail.com",
        "Br_23Kzn88Ql-1"
      ]
    }
  ],
  "keyword": "Dado "
});
formatter.match({
  "location": "EliminarProveedorStepDefinition.ingresarModuloProveedores(DatosLogin\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el administrador elimine el proveedor con NIT 9701234567",
  "keyword": "Cuando "
});
formatter.match({
  "location": "EliminarProveedorStepDefinition.eliminarProveedor(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el proveedor con NIT 9701234567 no debe aparecer en la lista",
  "keyword": "Entonces "
});
formatter.match({
  "location": "EliminarProveedorStepDefinition.verificarEliminacion(String)"
});
formatter.result({
  "status": "passed"
});
});