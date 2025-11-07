package co.com.Automatizacion.stepsdefinitions.Proveedor;

import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.tasks.Proveedor.AbrirPagina;
import co.com.Automatizacion.tasks.Proveedor.EliminarProveedor;
import co.com.Automatizacion.tasks.Proveedor.IngresarModuloProveedor;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static co.com.Automatizacion.questions.Proveedor.ValidarEliminacionProveedor.noExiste;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class EliminarProveedorStepDefinition {

    @Dado("^que el administrador esté en el módulo de proveedores con las credenciales:$")
    public void ingresarModuloProveedores(List<DatosLogin> datosLogin) {
        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloProveedor.con(datosLogin));
    }

    @Cuando("^el administrador elimine el proveedor con NIT (.*)$")
    public void eliminarProveedor(String nit) {
        theActorInTheSpotlight().attemptsTo(EliminarProveedor.conNIT(nit));
    }

    @Entonces("^el proveedor con NIT (.*) no debe aparecer en la lista$")
    public void verificarEliminacion(String nit) {
        theActorInTheSpotlight().should(seeThat(noExiste(nit)));
    }

}
