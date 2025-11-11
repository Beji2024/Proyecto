package co.com.Automatizacion.tasks.Proveedor;


import co.com.Automatizacion.userinterface.Proveedor.InicioPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirPagina implements Task {

    InicioPagina inicioPagina;
    public static AbrirPagina paginael(){return Tasks.instrumented(AbrirPagina.class);}

    @Override
    public <T extends Actor> void performAs(T actor){actor.attemptsTo(Open.browserOn(inicioPagina));}
}
