package co.com.Automatizacion.tasks.Producto;

import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.userinterface.Productos.Producto;
import co.com.Automatizacion.userinterface.Usuarios.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarModuloProducto implements Task {

    private final List<DatosLogin> datosLogin;

    public IngresarModuloProducto(List<DatosLogin> datosLogin) {
        this.datosLogin = datosLogin;
    }

    public static IngresarModuloProducto con(List<DatosLogin> datosLogin) {
        return instrumented(IngresarModuloProducto.class, datosLogin);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Abre la página de login (Login debe extender PageObject y estar correctamente configurada)
        actor.attemptsTo(Open.browserOn().the(Login.class));

        // Ingresa credenciales (usa los Targets definidos en tu clase Login)
        actor.attemptsTo(
                Enter.theValue(datosLogin.get(0).getEmail()).into(Login.INPUT_EMAIL),
                Enter.theValue(datosLogin.get(0).getPassword()).into(Login.INPUT_PASSWORD),
                Click.on(Login.BTN_INGRESAR)
        );

        // Espera y navega al módulo Productos usando los Targets que ya definiste en Producto.java
        actor.attemptsTo(
                WaitUntil.the(Producto.BTN_PRODUCTO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Producto.BTN_PRODUCTO),
                Click.on(Producto.BTN_MASOPCIONES),
                WaitUntil.the(Producto.BTN_GESTIONARPRODUCTOS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Producto.BTN_GESTIONARPRODUCTOS)
        );
    }
}
