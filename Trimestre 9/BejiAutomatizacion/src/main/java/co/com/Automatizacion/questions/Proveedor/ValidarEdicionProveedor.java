package co.com.Automatizacion.questions.Proveedor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarEdicionProveedor implements Question<Boolean> {

    public static final Target TITULO_DATOS_PROVEEDORES = Target.the("Título de la página DATOS PROVEEDORES")
            .locatedBy("//h2[contains(text(), 'DATOS PROVEEDORES')]");

    public static ValidarEdicionProveedor tituloVisible() {
        return new ValidarEdicionProveedor();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(TITULO_DATOS_PROVEEDORES).viewedBy(actor).asBoolean();
    }
}
