package co.com.Automatizacion.questions.Producto;

import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
<<<<<<< HEAD
=======
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548

public class ValidarCreacionProducto implements Question<Boolean> {

    private final String nombreProducto;

<<<<<<< HEAD
    // ✅ Método estático de fábrica (solo uno)
    public static ValidarCreacionProducto esVisible(String nombreProducto) {
        return new ValidarCreacionProducto(nombreProducto);
    }

=======
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
    public ValidarCreacionProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

<<<<<<< HEAD
    @Override
    public Boolean answeredBy(Actor actor) {
=======
    public static ValidarCreacionProducto esVisible(String nombreProducto) {
        return new ValidarCreacionProducto(nombreProducto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(Producto.TABLA_PRODUCTOS, isVisible()).forNoMoreThan(20).seconds()
        );

>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
        String textoTabla = Text.of(Producto.TABLA_PRODUCTOS)
                .viewedBy(actor)
                .asString()
                .toLowerCase();

<<<<<<< HEAD
        return textoTabla.contains(nombreProducto.toLowerCase());
    }
}
=======
        return textoTabla.contains(nombreProducto.trim().toLowerCase());
    }
}

>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
