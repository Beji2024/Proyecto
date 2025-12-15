package co.com.Automatizacion.questions.Venta;

import co.com.Automatizacion.userinterface.venta.Venta;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ValidarCreacionVenta implements Question<Boolean> {

    public static ValidarCreacionVenta esExitosa() {
        return new ValidarCreacionVenta();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String nombre = actor.recall(RegistroVariable.venta.toString());
        return Visibility.of(Venta.CLIENTE_EN_TABLA(nombre)).viewedBy(actor).asBoolean();
    }
}
