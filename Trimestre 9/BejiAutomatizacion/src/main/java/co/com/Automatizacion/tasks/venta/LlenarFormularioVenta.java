package co.com.Automatizacion.tasks.venta;


import co.com.Automatizacion.userinterface.venta.FormularioVenta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarFormularioVenta implements Task {

    private final String nombre;
    private final String direccion;
    private final String correo;
    private final String telefono;
    private final String documento;
    private final String referencia;
    private final String cantidad;
    private final String vendedor;

    public LlenarFormularioVenta(String nombre, String direccion, String correo,
                                 String telefono, String documento, String referencia,
                                 String cantidad, String vendedor) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.documento = documento;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.vendedor = vendedor;
    }

    public static LlenarFormularioVenta conDatos(
            String nombre, String direccion, String correo, String telefono,
            String documento, String referencia, String cantidad, String vendedor) {
        return instrumented(LlenarFormularioVenta.class, nombre, direccion, correo,
                telefono, documento, referencia, cantidad, vendedor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(FormularioVenta.NOMBRE_CLIENTE),
                Enter.theValue(direccion).into(FormularioVenta.DIRECCION_CLIENTE),
                Enter.theValue(correo).into(FormularioVenta.CORREO_CLIENTE),
                Enter.theValue(telefono).into(FormularioVenta.TELEFONO_CLIENTE),
                Enter.theValue(documento).into(FormularioVenta.DOCUMENTO_CLIENTE),

                SelectFromOptions.byValue(referencia).from(FormularioVenta.SELECT_REFERENCIA),
                Enter.theValue(cantidad).into(FormularioVenta.CANTIDAD),
                SelectFromOptions.byValue(vendedor).from(FormularioVenta.SELECT_VENDEDOR),

                Click.on(FormularioVenta.BTN_REGISTRAR)
        );
    }
}
