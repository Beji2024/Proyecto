package co.com.Automatizacion.tasks.venta;


import co.com.Automatizacion.userinterface.venta.Cambios;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickEnBotonCambios implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Cambios.BTN_CAMBIOS)
        );
    }

    public static ClickEnBotonCambios ahora() {
        return instrumented(ClickEnBotonCambios.class);
    }
}
