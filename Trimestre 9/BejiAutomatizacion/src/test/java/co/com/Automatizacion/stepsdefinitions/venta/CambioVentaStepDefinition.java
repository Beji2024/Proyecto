package co.com.Automatizacion.stepsdefinitions.venta;

import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.questions.Venta.ValidarCambioVenta;
import co.com.Automatizacion.tasks.venta.CambioVenta;
import co.com.Automatizacion.tasks.venta.IngresarModuloVenta;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CambioVentaStepDefinition {

    @Dado("^que el administrador esté en el módulo principal con las credenciales de administrador:$")
    public void queElAdministradorEsteEnElModuloDeVentasConLasCredenciales(List<DatosLogin> credenciales) {

        setTheStage(new OnlineCast());
        theActorCalled("Administrador").attemptsTo(IngresarModuloVenta.con(credenciales));
    }


    @Cuando("^el administrador realice el cambio ha devuelto$")
    public void elAdministradorRealiceElCambioHaDevuelto() {
        theActorCalled("Administrador").attemptsTo(
                CambioVenta.realizar()
        );
    }

    @Entonces("^El cambio se debe reflejar como Cambio de producto$")
    public void elCambioSeDebeReflejarComoCambioDeProducto() {
        theActorCalled("Administrador").should(
                seeThat(ValidarCambioVenta.fueExitosa())
        );
    }
}
