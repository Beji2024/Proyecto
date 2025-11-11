package co.com.Automatizacion.questions.Producto;

import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarCreacionProducto implements Question<Boolean> {

    private final String nombreProducto;

    // ✅ Método estático de fábrica (solo uno)
    public static ValidarCreacionProducto esVisible(String nombreProducto) {
        return new ValidarCreacionProducto(nombreProducto);
    }

    public ValidarCreacionProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String textoTabla = Text.of(Producto.TABLA_PRODUCTOS)
                .viewedBy(actor)
                .asString()
                .toLowerCase();

        return textoTabla.contains(nombreProducto.toLowerCase());
    }
}
