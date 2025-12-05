package co.com.Automatizacion.tasks.Proveedor;

import co.com.Automatizacion.interactions.AceptarAlerta;
import co.com.Automatizacion.models.Proveedor.DatosProveedor;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

import static co.com.Automatizacion.userinterface.Proveedor.Proveedor.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class Formulario_Proveedor implements Task {

    private final List<DatosProveedor> datos;

    public Formulario_Proveedor(List<DatosProveedor> datos) {
        this.datos = datos;
    }

    public static Formulario_Proveedor conDatos(List<DatosProveedor> datos) {
        return Instrumented.instanceOf(Formulario_Proveedor.class).withProperties(datos);
    }

    Random rand=new Random();
    int numero= rand.nextInt(1000);

    @Override
    public <T extends Actor> void performAs(T actor) {
        DatosProveedor proveedor = datos.get(0);
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        String emailBase = proveedor.getEmail();
        String[] partes = emailBase.split("@");
        String emailRandom = partes[0] + numero + "@" + partes[1];
        String nitCompleto = proveedor.getNit() + numero;

        actor.attemptsTo(
                Click.on(TXT_NOMBRE),
                Enter.theValue(proveedor.getNombre()+numero).into(TXT_NOMBRE),

                Click.on(TXT_NIT),
                Enter.theValue(nitCompleto).into(TXT_NIT),

                Click.on(TXT_CELULAR),
                Enter.theValue(proveedor.getCelular()).into(TXT_CELULAR),

                Click.on(TXT_EMAIL),
                Enter.theValue(emailRandom).into(TXT_EMAIL),

                Click.on(TXT_DIRECCION),
                Enter.theValue(proveedor.getDireccion()+numero).into(TXT_DIRECCION),

                Click.on(BTN_REGISTRAR)
        );

        actor.attemptsTo(AceptarAlerta.ahora());
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            actor.attemptsTo(AceptarAlerta.ahora());
        } catch (Exception e) {
            System.out.println("No apareció el segundo alert dentro del tiempo esperado");
        }

        actor.remember(RegistroVariable.PROVEEDOR_NIT.name(), nitCompleto);
    }

}


