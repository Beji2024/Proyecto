package co.com.Automatizacion.userinterface.login.venta;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VentaPagina extends PageObject {

    public static final Target BTN_CONSULTAR_VENTA = Target.the("Botón Consultar Venta")
            .located(By.xpath("//img[contains(@src,'14255792.gif')]"));




}
