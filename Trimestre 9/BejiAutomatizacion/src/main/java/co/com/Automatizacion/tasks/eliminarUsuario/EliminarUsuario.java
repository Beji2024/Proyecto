package co.com.Automatizacion.tasks.eliminarUsuario;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.Automatizacion.userinterface.eliminarUsuario.EliminarUsuario.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarUsuario implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Hacer clic en el módulo "Usuarios"
        actor.attemptsTo(
                WaitUntil.the(BTN_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_USUARIO)
        );

        // Esperar que la columna de documentos esté visible
        actor.attemptsTo(
                WaitUntil.the(COLUMNA_NUMDOC, isVisible()).forNoMoreThan(10).seconds()
        );

        // Avanzar hasta la última página usando el botón "Siguiente"
        while (BTN_SIGUIENTE.resolveFor(actor).isEnabled()) {
            WebElement siguiente = BTN_SIGUIENTE.resolveFor(actor);
            ((JavascriptExecutor) Serenity.getDriver()).executeScript("arguments[0].scrollIntoView(true);", siguiente);
            siguiente.click();

            // Espera breve para que carguen los nuevos registros
            actor.attemptsTo(
                    WaitUntil.the(COLUMNA_NUMDOC, isVisible()).forNoMoreThan(5).seconds()
            );
        }

        // Obtener todas las filas (números de documento visibles)
        List<WebElementFacade> documentos = COLUMNA_NUMDOC.resolveAllFor(actor);

        if (documentos.isEmpty()) {
            throw new RuntimeException("No se encontraron registros en la columna de documentos.");
        }

        // Tomar el último registro
        WebElementFacade ultimoRegistro = documentos.get(documentos.size() - 1);
        String numeroDocumento = ultimoRegistro.getText().trim();

        // Guardar el número de documento en memoria
        theActorInTheSpotlight().remember(
                "NUMERO_DOCUMENTO",
                numeroDocumento
        );

        System.out.println("Último número de documento encontrado: " + numeroDocumento);
    }

    public static BuscarUltimoRegistro enLaTabla() {
        return new BuscarUltimoRegistro();
    }
}

