package co.com.Automatizacion.questions.Venta;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class Elemento implements Question<Boolean> {

    private final Target elemento;

    public Elemento(Target elemento) {
        this.elemento = elemento;
    }

    public static Elemento esVisible(Target elemento) {
        return new Elemento(elemento);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return elemento.resolveFor(actor).isVisible();
    }
}
