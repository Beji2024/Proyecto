package co.com.Automatizacion.userinterface.Proveedor;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class EditarProveedor {

    public static Target BTN_SIGUIENTE =
            Target.the("Botón siguiente página")
                    .located(By.xpath("//button[contains(normalize-space(.),'Siguiente')]"));
    public static final Target BTN_ANTERIOR = Target.the("botón anterior")
            .located(By.id("btn-anterior"));

    public static Target EDT_CELULAR = Target.the("Campo celular del proveedor")
            .located(By.id("celular"));

    public static Target EDT_EMAIL = Target.the("Campo email del proveedor")
            .located(By.id("email"));
    public static Target EDT_DIRECCION = Target.the("Campo direccion del proveedor")
            .located(By.id("direccion"));

    public static Target BTN_ACTUALIZAR = Target.the("Botón actualizar")
            .located(By.xpath("//button[text()='Actualizar']"));
    public static Target COL_EMAIL_TABLA =
            Target.the("Columna email del proveedor en la tabla")
                    .locatedBy("//table/tbody/tr/td[4]");
}
