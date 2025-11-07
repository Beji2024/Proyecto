package co.com.Automatizacion.stepsdefinitions;

import co.com.Automatizacion.models.DatosEditar;
import co.com.Automatizacion.tasks.AbrirPagina;
import co.com.Automatizacion.tasks.EditarUsuario;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import co.com.Automatizacion.questions.ValidacionEditar;

public class EditarUsuarioStepDefinition {
    @Dado("^que el usuario se encuentre en la pagina en el modulo de usuarios para editar$")
    public void queElUsuarioSeEncuentreEnLaPaginaEnElModuloDeUsuariosParaEditar() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.pagina());
    }

    @Cuando("^ingrese los datos que desee modificar para editar el registro:$")
    public void ingreseLosDatosQueDeseeModificarParaEditarElRegistro(List<DatosEditar>datos) {
        theActorInTheSpotlight().attemptsTo(EditarUsuario.editarUsuario(datos));
    }

    @Entonces("^Se debe verificar que los datos modificados del usuario esten en el nuevo registro$")
    public void seDebeVerificarQueLosDatosModificadosDelUsuarioEstenEnElNuevoRegistro() {
        theActorInTheSpotlight().should(seeThat(ValidacionEditar.validacionEditar()));
    }
}
