package co.com.Automatizacion.tasks.Usuarios;

import static co.com.Automatizacion.userinterface.Usuarios.EliminarUsuario.*;
import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import co.com.Automatizacion.interactions.AceptarAlerta;

import java.util.List;

public class EliminarUsuario implements Task {

AceptarAlerta aceptar = new AceptarAlerta();
    @Override
    public <T extends Actor> void performAs(T actor) {
        ScrollBottom scrollBottom = new ScrollBottom();


        actor.attemptsTo(
                Click.on(BTN_USUARIO),
                scrollBottom,
                scrollBottom,
                Click.on(BTN_SIGUIENTE),
                Click.on(BTN_SIGUIENTE)
        );
        List<WebElementFacade> documentos = COLUMNA_DOCUMENTO.resolveAllFor(actor);
        String documentoAEliminar = documentos.get(documentos.size() - 1).getText().trim();
        Serenity.setSessionVariable(RegistroVariable.usuario.toString()).to(documentoAEliminar);
        actor.remember(RegistroVariable.usuario.toString(), documentoAEliminar);

                actor.attemptsTo(
                Click.on(BTN_ELIMINAR),
                aceptar,
                scrollBottom
        );
    }
    public static EliminarUsuario eliminar() {
       return instrumented(EliminarUsuario.class);
    }
}

