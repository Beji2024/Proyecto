package co.com.Automatizacion.userinterface.Proveedor;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class Proveedor extends PageObject {

    public static Target BTN_PROVEEDOR = Target.the("Botón para ir a proveedor")
            .located(By.id("proveedor"));
    public static Target BTN_REGISTRAR_PROVEEDOR = Target.the("Botón para registrar proveedor")
            .located(By.cssSelector("a[routerlink='/regproveedores']"));

    public static Target TXT_NOMBRE = Target.the("Campo nombre del proveedor")
            .located(By.cssSelector("input[formcontrolname='nombre']"));
    public static Target TXT_NIT = Target.the("Campo nit del proveedor")
            .located(By.cssSelector("input[formcontrolname='nit']"));

    public static Target TXT_CELULAR = Target.the("Campo celular del proveedor")
            .located(By.cssSelector("input[formcontrolname='celular']"));

    public static Target TXT_EMAIL = Target.the("Campo email del proveedor")
            .located(By.cssSelector("input[formcontrolname='email']"));
    public static Target TXT_DIRECCION = Target.the("Campo direccion del proveedor")
            .located(By.cssSelector("input[formcontrolname='direccion']"));

    public static Target BTN_REGISTRAR = Target.the("Boton para registrar proveedor")
            .located(By.id("registrar"));

    public static final Target INPUT_CONFIRMACION = Target.the("Mensaje de inicio del sistema")
            .located(By.id("Titulo"));

    public static final Target COLUMNA_NIT = Target.the("columna NIT del proveedor")
            .located(By.xpath("//table//tbody//tr//td[2]"));

    public static Target BTN_SIGUIENTE =
            Target.the("Botón siguiente página")
                    .located(By.xpath("//button[contains(normalize-space(.),'Siguiente')]"));
    public static Target BTN_ELIMINAR_PROVEEDOR(String nit) {
        return Target.the("botón eliminar proveedor")
                .located(By.xpath("//td[text()='" + nit + "']/following-sibling::td//button[contains(@class,'btn-danger')]"));
    }


}


