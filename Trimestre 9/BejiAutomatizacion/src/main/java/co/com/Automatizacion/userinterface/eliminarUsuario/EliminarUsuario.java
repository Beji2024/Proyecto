package co.com.Automatizacion.userinterface.eliminarUsuario;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EliminarUsuario extends PageObject {
    public static Target BTN_USUARIO = Target.the("Boton de modulo usuario")
            .located(By.id("usuarios"));
    public static Target COLUMNA_NUMDOC = Target.the("Columna de numeros de documento")
            .located(By.id("documento"));
    public static Target BTN_SIGUIENTE = Target.the("Siguiente pagina boton")
            .located(By.id("siguiente"));
    public static Target BTN_ELIMINAR = Target.the("Boton de eliminar")
            .locatedBy("//td[contains(@class, 'list-group-item') and contains(@class, 'documento')]");
}
