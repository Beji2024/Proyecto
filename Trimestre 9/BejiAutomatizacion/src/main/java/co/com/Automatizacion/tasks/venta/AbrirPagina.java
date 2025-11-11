package co.com.Automatizacion.tasks.login.venta;

import co.com.Automatizacion.userinterface.login.venta.InicioPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Task;

public class AbrirPagina implements Task {

    InicioPagina inicioPagina;
    public static AbrirPagina pagina(){ return Tasks.instrumented(AbrirPagina.class);}
    @Override
    public <T extends Actor> void performAs(T actor){actor.attemptsTo(Open.browserOn(inicioPagina));}
}
