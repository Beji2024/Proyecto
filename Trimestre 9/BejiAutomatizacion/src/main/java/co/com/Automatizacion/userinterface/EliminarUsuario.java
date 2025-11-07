package co.com.Automatizacion.userinterface;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EliminarUsuario extends PageObject {
    public static Target BTN_USUARIO = Target.the("Boton de modulo usuario")
            .located(By.id("usuarios"));
    public static final Target COLUMNA_DOCUMENTO = Target.the("columna de documentos")
            .locatedBy("//p[b[text()='Documento:']]");
    public static Target BTN_SIGUIENTE = Target.the("Siguiente pagina boton")
            .located(By.id("siguiente"));
    public static final Target BTN_ELIMINAR = Target.the("Botón eliminar del último usuario")
            .located(By.xpath("(//button[@id='eliminar'])[last()]"));
}



