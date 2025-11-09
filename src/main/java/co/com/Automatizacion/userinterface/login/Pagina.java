package co.com.Automatizacion.userinterface.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://localhost:4200/login")
public class Pagina extends PageObject {

    public static final Target BOTON_VENTA = Target.the("Botón Venta")
            .located(By.xpath("//img[@alt='Ir a Venta']"));

}
