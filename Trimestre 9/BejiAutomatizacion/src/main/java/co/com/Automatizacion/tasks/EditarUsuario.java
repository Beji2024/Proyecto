package co.com.Automatizacion.tasks;
import co.com.Automatizacion.interactions.AceptarAlerta;
import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.utils.hooks.RegistroVariable;
import net.serenitybdd.screenplay.Task;
import co.com.Automatizacion.models.DatosEditar;
import java.util.List;
import java.util.Random;
import net.serenitybdd.screenplay.Actor;
import static co.com.Automatizacion.userinterface.EditarUsuario.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EditarUsuario implements Task{

    private List<DatosEditar>datos;

    public EditarUsuario(List<DatosEditar> datos) {
        this.datos = datos;
    }
    public static EditarUsuario editarUsuario(List<DatosEditar>datos){
        return Instrumented.instanceOf(EditarUsuario.class).withProperties(datos);
    }

    String rol = "Administrador";
    Random random =new Random();
    int numero = random.nextInt(1000);
    AceptarAlerta alerta = new AceptarAlerta();
    ScrollBottom scrollBottom = new ScrollBottom();
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(BTN_USUARIO),
                scrollBottom,
                Click.on(BTN_SIGUIENTE),
                Click.on(BTN_SIGUIENTE),
                Click.on(BTN_EDITAR),
                scrollBottom,
                scrollBottom,
                Click.on(INPUT_NOMBRES),
                Enter.theValue(datos.get(0).getNombres()).into(INPUT_NOMBRES),
                Click.on(INPUT_APELLIDOS),
                Enter.theValue(datos.get(0).getApellidos()+numero).into(INPUT_APELLIDOS),
                Click.on(INPUT_DIRECCION),
                Enter.theValue(datos.get(0).getDireccion()).into(INPUT_DIRECCION),
                Click.on(INPUT_NUMTEL),
                Enter.theValue(datos.get(0).getNum_tel()).into(INPUT_NUMTEL),
                Click.on(INPUT_ROL),
                SelectFromOptions.byVisibleText(rol).from(INPUT_ROL),
                Click.on(BTN_ENVIAR),
                alerta
        );
        theActorInTheSpotlight().remember(RegistroVariable.usuario.toString(), datos.get(0).getApellidos()+numero);
    }

}


