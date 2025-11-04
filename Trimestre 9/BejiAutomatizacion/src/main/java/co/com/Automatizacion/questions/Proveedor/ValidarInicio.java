package co.com.Automatizacion.questions.Proveedor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.INPUT_CONFIRMACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarInicio implements Question<Boolean> {

    private static final String MENSAJE_ESPERADO = "SISTEMA DE INVENTARIO";

    public static ValidarInicio Ingreso() {
        return new ValidarInicio();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(INPUT_CONFIRMACION, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        String texto = Text.of(INPUT_CONFIRMACION).viewedBy(actor).asString().trim();

        return texto.equalsIgnoreCase(MENSAJE_ESPERADO);
    }
}
