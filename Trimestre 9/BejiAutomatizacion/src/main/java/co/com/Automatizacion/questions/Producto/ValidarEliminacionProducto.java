package co.com.Automatizacion.questions.Producto;

import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class ValidarEliminacionProducto implements Question<Boolean> {

    ScrollBottom scrollBottom = new ScrollBottom();
    private final String nombreProducto;

    public ValidarEliminacionProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static ValidarEliminacionProducto noExiste(String nombreProducto) {
        return new ValidarEliminacionProducto(nombreProducto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            actor.attemptsTo(
                    scrollBottom,
                    WaitUntil.the(Producto.elementoProducto(nombreProducto), isNotVisible())
                            .forNoMoreThan(5).seconds()
            );
        } catch (Exception e) {

            return true;
        }


        boolean existe = !Producto.elementoProducto(nombreProducto)
                .resolveAllFor(actor)
                .isEmpty();

        return !existe;
    }

}


