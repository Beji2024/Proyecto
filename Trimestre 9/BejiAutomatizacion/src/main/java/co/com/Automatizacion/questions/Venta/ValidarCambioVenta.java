package co.com.Automatizacion.questions.Venta;

import co.com.Automatizacion.userinterface.venta.Venta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarCambioVenta implements Question<Boolean> {

    public static ValidarCambioVenta fueExitosa() {
        return new ValidarCambioVenta();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        int intentos = 0;

        while (Venta.BTN_SIGUIENTE.resolveFor(actor).isEnabled() && intentos < 10) {
            actor.attemptsTo(
                    Click.on(Venta.BTN_SIGUIENTE)
            );
            intentos++;
        }

        String estado = Text.of(Venta.ESTADO_DEVOLUCION_TABLA)
                .viewedBy(actor)
                .asString();

        return estado.equalsIgnoreCase("Cambio de producto");
    }
}

