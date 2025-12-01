package co.com.Automatizacion.tasks.venta;

import co.com.Automatizacion.userinterface.venta.BotonDevoluciones;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickEnDevoluciones implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(BotonDevoluciones.BTN_DEVOLUCIONES),
                WaitUntil.the(BotonDevoluciones.BTN_DEVOLUCIONES, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(BotonDevoluciones.BTN_DEVOLUCIONES)
        );
    }

    public static ClickEnDevoluciones ahora() {
        return Tasks.instrumented(ClickEnDevoluciones.class);
    }
}

