package co.com.Automatizacion.tasks.venta;

import co.com.Automatizacion.userinterface.venta.CrearVenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickCrearVenta implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CrearVenta.BTN_CREAR_VENTA)
        );
    }

    public static ClickCrearVenta ahora() {
        return Tasks.instrumented(ClickCrearVenta.class);
    }
}
