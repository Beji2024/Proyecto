package co.com.Automatizacion.questions.Producto;

import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarCreacionProducto implements Question<Boolean> {

    private final String nombreProducto;

    public ValidarCreacionProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static ValidarCreacionProducto esVisible(String nombreProducto) {
        return new ValidarCreacionProducto(nombreProducto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(Producto.TABLA_PRODUCTOS, isVisible()).forNoMoreThan(20).seconds()
        );

        String textoTabla = Text.of(Producto.TABLA_PRODUCTOS)
                .viewedBy(actor)
                .asString()
                .toLowerCase();

        return textoTabla.contains(nombreProducto.trim().toLowerCase());
    }
}

