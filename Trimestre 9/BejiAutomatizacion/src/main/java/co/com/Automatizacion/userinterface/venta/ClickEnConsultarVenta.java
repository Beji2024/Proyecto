package co.com.Automatizacion.userinterface.login.venta;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


import static co.com.Automatizacion.userinterface.login.venta.VentaPagina.BTN_CONSULTAR_VENTA;


public class ClickEnConsultarVenta implements Task {

    public static ClickEnConsultarVenta ahora() {
        return new ClickEnConsultarVenta();
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CONSULTAR_VENTA)
        );
    }
}
