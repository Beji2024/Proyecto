package co.com.Automatizacion.tasks.venta;

import co.com.Automatizacion.interactions.AceptarAlerta;

import co.com.Automatizacion.userinterface.venta.BotonRealizarCambio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickEnRealizarCambio implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BotonRealizarCambio.BTN_REALIZAR_CAMBIO),
                AceptarAlerta.ahora()
        );
    }

    public static ClickEnRealizarCambio ahora() {
        return Tasks.instrumented(ClickEnRealizarCambio.class);
    }
}
