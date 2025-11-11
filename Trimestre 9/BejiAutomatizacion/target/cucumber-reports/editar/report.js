$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/EditarProveedor.feature");
formatter.feature({
  "name": "Editar proveedor existente",
  "description": "  Como administrador del sistema\n  Quiero editar un proveedor existente\n  Para actualizar su información en el sistema",
  "keyword": "Característica"
});
formatter.scenario({
  "name": "Editar un proveedor exitosamente",
  "description": "",
  "keyword": "Escenario",
  "tags": [
    {
      "name": "@EditarProveedor"
    }
  ]
});
formatter.step({
  "name": "que el administrador haya accedido al módulo de proveedores con las credenciales:",
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
  "location": "EditarProveedorStepDefinition.ingresarModuloProveedores(DatosLogin\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el administrador edite el proveedor con NIT 9701234567 con los siguientes datos:",
  "rows": [
    {
      "cells": [
        "celular",
        "email",
        "direccion"
      ]
    },
    {
      "cells": [
        "3115557788",
        "contacto@calzadosdeportivos.com",
        "Av. 9 #100-99 Cali"
      ]
    }
  ],
  "keyword": "Cuando "
});
formatter.match({
  "location": "EditarProveedorStepDefinition.editarProveedor(String,DatosProveedor\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se debe verificar que el proveedor haya sido actualizado correctamente",
  "keyword": "Entonces "
});
formatter.match({
  "location": "EditarProveedorStepDefinition.verificarEdicion()"
});
formatter.result({
  "status": "passed"
});
});