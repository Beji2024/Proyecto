package co.com.Automatizacion.tasks.eliminarUsuario;

import co.com.Automatizacion.tasks.registrarUsuario.RegistrarUsuario;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;
import static co.com.Automatizacion.userinterface.eliminarUsuario.EliminarUsuario.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import co.com.Automatizacion.utils.hooks.eliminarUsuario.RegistroVariable;
import co.com.Automatizacion.interactions.registrarUsuario.AceptarAlerta;
public class EliminarUsuario implements Task {

    public static EliminarUsuario eliminarUsuario (){
        return Instrumented.instanceOf(EliminarUsuario.class).withProperties();
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(BTN_USUARIO),
                Click.on(COLUMNA_NUMDOC),
                Click.on(BTN_ELIMINAR),
                AceptarAlerta.ahora()
        );
        theActorInTheSpotlight().remember(RegistroVariable.registro.toString(),COLUMNA_NUMDOC);
    }
}
