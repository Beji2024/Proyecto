package co.com.Automatizacion.tasks.Proveedor;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.BTN_REGISTRAR_PROVEEDOR;

public class BTN_Registrar implements Task {

    public static BTN_Registrar btn_registrar() {
        return Instrumented.instanceOf(BTN_Registrar.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_REGISTRAR_PROVEEDOR)
        );
    }
}
