package co.com.Automatizacion.questions.Venta;

import co.com.Automatizacion.userinterface.venta.Venta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarDevolucion implements Question<Boolean> {

    public static ValidarDevolucion fueExitosa() {
        return new ValidarDevolucion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String estado = Text.of(Venta.ESTADO_DEVOLUCION_TABLA)
                .viewedBy(actor)
                .asString();

        return estado.equalsIgnoreCase("Devolucion de dinero");
    }
}