package co.com.Automatizacion.tasks.venta;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.models.Usuarios.DatosLogin;
import co.com.Automatizacion.userinterface.venta.Venta;
import co.com.Automatizacion.userinterface.Usuarios.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Enter;


import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarModuloVenta implements Task {

    private final List<DatosLogin> datosLogin;
    Esperar esperar = new Esperar(4);

    public IngresarModuloVenta(List<DatosLogin> datosLogin) {
        this.datosLogin = datosLogin;
    }

    public static IngresarModuloVenta con(List<DatosLogin> datosLogin) {
        return instrumented(IngresarModuloVenta.class, datosLogin);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {



        actor.attemptsTo(Open.browserOn().the(Login.class));


        actor.attemptsTo(
                Enter.theValue(datosLogin.get(0).getEmail()).into(Login.INPUT_EMAIL),
                Enter.theValue(datosLogin.get(0).getPassword()).into(Login.INPUT_PASSWORD),
                Click.on(Login.BTN_INGRESAR)
        );

        actor.attemptsTo(
                esperar,
                Click.on(Venta.BOTON_VENTA)
        );
    }
}


