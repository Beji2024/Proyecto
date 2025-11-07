package co.com.Automatizacion.stepsdefinitions;

import co.com.Automatizacion.models.login.DatosLogin;
import co.com.Automatizacion.questions.login.ValidacionLogin;
import co.com.Automatizacion.tasks.login.AbrirPagina;
import co.com.Automatizacion.tasks.login.Login;
import java.util.List;
import cucumber.api.DataTable;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class LoginStepDefinition {
    @Dado("^que el administrador este en la pagina$")
    public void queElAdministradorEsteEnLaPagina() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.pagina());
    }

    @Cuando("^ingrese las crendenciales para loguearse:$")
    public void ingreseLasCrendencialesParaLoguearse(List<DatosLogin>datos) {
        theActorInTheSpotlight().attemptsTo(Login.login(datos));

    }

    @Entonces("^Se debe verificar que el administrador haya ingresado correctamente a la página y tenga acceso a sus funciones$")
    public void seDebeVerificarQueElAdministradorHayaIngresadoCorrectamenteALaPáginaYTengaAccesoASusFunciones() {
        theActorInTheSpotlight().should(seeThat(ValidacionLogin.validacionLogin()));
    }
}
