package co.com.Automatizacion.stepsdefinitions;

import co.com.Automatizacion.tasks.Proveedor.AbrirPagina;
import co.com.Automatizacion.tasks.Proveedor.EliminarProveedor;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarProveedorStepDefinition {

    @Dado("^que el administrador se encuentre en la pagina en el modulo de proveedores$")
    public void queElAdministradorSeEncuentreEnLaPaginaEnElModuloDeProveedores() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.paginael());
    }

    @Dado("^exista un proveedor registrado con NIT \"([^\"]*)\"$")
    public void existaUnProveedorRegistradoConNIT(String nit) {

    }

    @Cuando("^de en el boton de eliminar y confirme la accion con NIT \"([^\"]*)\"$")
    public void deEnElBotonDeEliminarYConfirmeLaAccion(String nit) {
        theActorInTheSpotlight().attemptsTo(EliminarProveedor.conNit(nit));
    }

    @Entonces("^se debe verificar que el proveedor con NIT \"([^\"]*)\" se haya eliminado de la pagina web$")
    public void seDebeVerificarQueElProveedorSeHayaEliminadoDeLaPaginaWeb(String nit) {

    }
}
