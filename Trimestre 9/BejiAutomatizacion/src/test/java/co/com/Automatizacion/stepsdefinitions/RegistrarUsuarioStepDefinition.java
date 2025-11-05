package co.com.Automatizacion.stepsdefinitions;

import co.com.Automatizacion.models.DatosRegistro;
import co.com.Automatizacion.tasks.AbrirPagina;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import co.com.Automatizacion.tasks.RegistrarUsuario;
import co.com.Automatizacion.questions.ValidacionRegistro;
import java.util.List;

public class RegistrarUsuarioStepDefinition {
    @Dado("^que el usuario se encuentre en la pagina de pruebas en el modulo de usuarios$")
    public void queElUsuarioSeEncuentreEnLaPaginaDePruebasEnElMduloDeUsuarios() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.pagina());
    }

    @Cuando("^ingresa los datos necesarios para el registro del usuario:$")
    public void ingresaLosDatosNecesariosParaElRegistroDelUsuario(List<DatosRegistro>datos) {
        theActorInTheSpotlight().attemptsTo(RegistrarUsuario.registarUsuario(datos));
    }

    @Entonces("^Se debe verificar que el usuario este registrado en la seccion de registros$")
    public void seDebeVerificarQueElUsuarioEsteRegistradoEnLaSeccionDeRegistros() {
        theActorInTheSpotlight().should(seeThat(ValidacionRegistro.validacionRegistro()));
    }
}