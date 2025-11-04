package co.com.Automatizacion.tasks;

import java.util.List;
import co.com.Automatizacion.models.DatosLogin;
import static co.com.Automatizacion.userinterface.Login.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Actor;
public class Login  implements Task{
    private List<DatosLogin>datos;
    public Login (List<DatosLogin>datos){this.datos=datos;}
    public static Login login(List<DatosLogin>datos){
        return Instrumented.instanceOf(Login.class).withProperties(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(INPUT_EMAIL),
                Enter.theValue(datos.get(0).getEmail()).into(INPUT_EMAIL),
                Click.on(INPUT_PASSWORD),
                Enter.theValue(datos.get(0).getPassword()).into(INPUT_PASSWORD),
                Click.on(BTN_INGRESAR)
        );
    }
}
