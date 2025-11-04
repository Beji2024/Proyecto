package co.com.Automatizacion.stepsdefinitions;

import co.com.Automatizacion.tasks.eliminarUsuario.EliminarUsuario;
import co.com.Automatizacion.tasks.registrarUsuario.AbrirPagina;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarUsuarioStepDefinition {
    @Dado("^que el usuario se encuentre en la pagina en el modulo de usuarios$")
    public void queElUsuarioSeEncuentreEnLaPaginaEnElModuloDeUsuarios() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.pagina());
    }


    @Cuando("^de en el boton de eliminar y confirme la accion$")
    public void deEnElBotonDeEliminarYConfirmeLaAccion() {
        theActorInTheSpotlight().attemptsTo(EliminarUsuario.());
    }

    @Entonces("^Se debe verificar que el usuario se hay eliminado de la pagina web$")
    public void seDebeVerificarQueElUsuarioSeHayEliminadoDeLaPaginaWeb() {
    }
}
