package co.com.Automatizacion.tasks.Proveedor;

import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.questions.Proveedor.ValidarInicio;
import co.com.Automatizacion.tasks.Usuarios.AbrirPagina;
import co.com.Automatizacion.tasks.Usuarios.Login;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class IngresarModuloProveedor implements Task {

    private final List<DatosLogin> datosLogin;

    public IngresarModuloProveedor(List<DatosLogin> datosLogin) {
        this.datosLogin = datosLogin;
    }

    public static IngresarModuloProveedor con(List<DatosLogin> datosLogin) {
        return Instrumented.instanceOf(IngresarModuloProveedor.class).withProperties(datosLogin);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                AbrirPagina.pagina(),
                Login.login(datosLogin)
        );

        actor.should(seeThat(ValidarInicio.Ingreso()));

        actor.attemptsTo(
                IrProveedor.irProveedor()
        );
    }
}

