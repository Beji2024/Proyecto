package co.com.Automatizacion.tasks.Proveedor;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.BTN_PROVEEDOR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IrProveedor implements Task {

    public static IrProveedor irProveedor() {
        return Instrumented.instanceOf(IrProveedor.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_PROVEEDOR, isClickable()).forNoMoreThan(120).seconds(),
                Click.on(BTN_PROVEEDOR)
        );
    }
}