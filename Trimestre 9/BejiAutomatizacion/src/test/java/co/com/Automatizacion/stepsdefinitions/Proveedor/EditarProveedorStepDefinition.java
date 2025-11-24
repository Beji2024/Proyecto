package co.com.Automatizacion.stepsdefinitions.Proveedor;

import co.com.Automatizacion.models.Proveedor.DatosProveedor;
import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.questions.Proveedor.ValidarEdicionProveedor;
import co.com.Automatizacion.questions.Proveedor.ValidarInicio;
import co.com.Automatizacion.questions.Usuarios.ValidacionLogin;
import co.com.Automatizacion.tasks.Proveedor.EditarProveedor;
import co.com.Automatizacion.tasks.Proveedor.IngresarModuloProveedor;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class EditarProveedorStepDefinition {

    @Dado("^que el administrador haya accedido al módulo de proveedores con las credenciales:$")
    public void ingresarModuloProveedores(List<DatosLogin> datosLogin) {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(
                IngresarModuloProveedor.con(datosLogin)
        );
    }
    @Entonces("^se debe verificar que el administrador haya ingresado correctamente y tenga acceso a sus funciones$")
    public void verificarAccesoAdministrador() {
        theActorInTheSpotlight().should(seeThat(ValidarInicio.Ingreso()));
    }

    @Dado("^que el administrador se encuentre en el módulo de proveedores para editar$")
    public void administradorEnModuloProveedorParaEditar() {
        System.out.println("Administrador está listo para editar proveedores.");
    }

    @Cuando("^el administrador edite un proveedor con los siguientes datos:$")
    public void editarProveedor(List<DatosProveedor> datos) {
        theActorInTheSpotlight().attemptsTo(
                EditarProveedor.conDatos(datos)
        );
    }

    @Entonces("^se debe verificar que el proveedor haya sido actualizado correctamente$")
    public void verificarEdicion() {
        theActorInTheSpotlight().should(
                seeThat(ValidarEdicionProveedor.validarEdicionProveedor())
        );
    }
}
