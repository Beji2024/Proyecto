package co.com.Automatizacion.tasks.registrarUsuario;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;
import java.util.List;
import co.com.Automatizacion.models.registrarUsuario.DatosRegistro;
import static co.com.Automatizacion.userinterface.registrarUsuario.RegistrarUsuario.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import co.com.Automatizacion.utils.hooks.registrarUsuario.VaribaleRegistro;
import co.com.Automatizacion.interactions.registrarUsuario.AceptarAlerta;

public class RegistrarUsuario implements Task{
    private List<DatosRegistro>datos;

    public RegistrarUsuario (List<DatosRegistro>datos){this.datos=datos;}
    public static RegistrarUsuario registarUsuario(List<DatosRegistro>datos){
        return Instrumented.instanceOf(RegistrarUsuario.class).withProperties(datos);
    }
    String doc = "Cédula de ciudadanía";
    String rol = "Administrador";
    AceptarAlerta alerta = new AceptarAlerta();
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(BTN_USUARIO),
                Click.on(BTN_NUEVO),
                Click.on(INPUT_NUMDOCUMENTO),
                Enter.theValue(datos.get(0).getNum_doc()).into(INPUT_NUMDOCUMENTO),
                Click.on(INPUT_NOMBRES),
                Enter.theValue(datos.get(0).getNombres()).into(INPUT_NOMBRES),
                Click.on(INPUT_APELLIDOS),
                Enter.theValue(datos.get(0).getApellidos()).into(INPUT_APELLIDOS),
                Click.on(INPUT_DIRECCION),
                Enter.theValue(datos.get(0).getDireccion()).into(INPUT_DIRECCION),
                Click.on(INPUT_CORREO),
                Enter.theValue(datos.get(0).getEmail()).into(INPUT_CORREO),
                Click.on(INPUT_TELEFONO),
                Enter.theValue(datos.get(0).getNum_tel()).into(INPUT_TELEFONO),
                Click.on(INPUT_FECHA),
                Enter.theValue(datos.get(0).getFec_nac()).into(INPUT_FECHA),
                Click.on(INPUT_CLAVE),
                Enter.theValue(datos.get(0).getPassword()).into(INPUT_CLAVE),
                Click.on(INPUT_TIPODOC),
                SelectFromOptions.byVisibleText(doc).from(INPUT_TIPODOC),
                Click.on(INPUT_ROL),
                SelectFromOptions.byVisibleText(rol).from(INPUT_ROL),
                Click.on(BTN_ENVIAR),
                alerta.ahora()

        );
        theActorInTheSpotlight().remember(VaribaleRegistro.registro.toString(),datos.get(0).getNum_doc());
    }
}
