package co.com.Automatizacion.tasks.venta;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.models.Venta.Ventas;
import co.com.Automatizacion.userinterface.venta.Venta;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearVenta implements Task {
    private List<Ventas> datos;

    public CrearVenta(List<Ventas> datos) {
        this.datos = datos;
    }

    public static CrearVenta con(List<Ventas> datos) {
        return Instrumented.instanceOf(CrearVenta.class).withProperties(datos);
    }

    Random rand = new Random();
    int numero = rand.nextInt(1000);

    @Override
    public <T extends Actor> void performAs(T actor) {

        Ventas venta = datos.get(0);

        actor.attemptsTo(
                Esperar.segundos(3),
                Click.on(Venta.BTN_CREAR_VENTA),

                Enter.theValue(venta.getNombre_cli()+numero).into(Venta.NOMBRE_CLIENTE),
                Enter.theValue(venta.getDireccion_cli()).into(Venta.DIRECCION_CLIENTE),
                Enter.theValue(venta.getCorreo_cli()).into(Venta.CORREO_CLIENTE),
                Enter.theValue(venta.getNum_tel_cli()).into(Venta.TELEFONO_CLIENTE),
                Enter.theValue(venta.getNum_doc_cli()).into(Venta.DOCUMENTO_CLIENTE),


                SelectFromOptions.byValue(venta.getReferencia()).from(Venta.SELECT_REFERENCIA),

                Enter.theValue(venta.getCantidad()).into(Venta.CANTIDAD),


                SelectFromOptions.byValue(venta.getVendedor()).from(Venta.SELECT_VENDEDOR),

                Click.on(Venta.BTN_REGISTRAR),
                Click.on(Venta.BTN_CONSULTAR_VENTA),
                Esperar.segundos(2)
        );
        theActorInTheSpotlight().remember(RegistroVariable.venta.toString(), datos.get(0).getNombre_cli()+numero);
    }
}
