package co.com.Automatizacion.questions.Producto;


import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.userinterface.Productos.Producto;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarCreacionProducto implements Question<Boolean> {

    ScrollBottom scrollBottom = new ScrollBottom();



    private static final Logger logger = LoggerFactory.getLogger(ValidarCreacionProducto.class);
    public static ValidarCreacionProducto validarCreacionProducto () {
        return new ValidarCreacionProducto();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String documento = actor.recall(RegistroVariable.producto.toString());
        actor.attemptsTo(
                scrollBottom,
                WaitUntil.the(Producto.TABLA_PRODUCTOS, isVisible()).forNoMoreThan(20).seconds()
        );

        String textoTabla = Text.of(Producto.TABLA_PRODUCTOS)
                .viewedBy(actor)
                .asString()
                .toLowerCase();
        logger.info("este es el producto",documento);
        return textoTabla.contains(documento.trim().toLowerCase());

    }

}

