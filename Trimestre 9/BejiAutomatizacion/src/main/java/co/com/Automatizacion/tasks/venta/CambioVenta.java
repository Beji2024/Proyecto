package co.com.Automatizacion.tasks.venta;

import co.com.Automatizacion.interactions.AceptarAlerta;
import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.userinterface.venta.Venta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CambioVenta implements Task {




    public static CambioVenta realizar() {
        return instrumented(CambioVenta.class);
    }

    ScrollBottom scrollBottom = new ScrollBottom();


    AceptarAlerta alerta = new AceptarAlerta();


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Venta.IMG_DEVOLUCION)
        );



        int intentos = 0;

        while (Venta.BTN_SIGUIENTE.resolveFor(actor).isEnabled() && intentos < 10) {
            actor.attemptsTo(
                    Click.on(Venta.BTN_SIGUIENTE)
            );
            intentos++;
        }
        actor.attemptsTo(
                Click.on(Venta.BTN_CAMBIA),
                alerta,
                Esperar.segundos(20),
                scrollBottom,

                Click.on(Venta.SELECT_REFERENCIAA),
                SelectFromOptions.byVisibleText("REF123")
                        .from(Venta.SELECT_REFERENCIAA),
                Click.on(Venta.BTN_GUARDAR),
                alerta,

                Esperar.segundos(2)
        );

    }
}
