package co.com.Automatizacion.userinterface.Usuarios;
 import net.serenitybdd.core.pages.PageObject;
 import net.serenitybdd.screenplay.targets.Target;
 import org.openqa.selenium.By;
public class EditarUsuario  extends PageObject{
    public static Target BTN_USUARIO = Target.the("Boton de modulo de usuario")
            .located(By.id("usuarios"));
    public static Target BTN_SIGUIENTE = Target.the("Boton de siguiente pagina")
            .located(By.id("siguiente"));
    public static final Target BTN_EDITAR = Target.the("Botón de editar registro")
            .located(By.xpath("(//button[@id='editar'])[last()]"));
    public static Target INPUT_NOMBRES = Target.the("Campo de nombres")
            .located(By.id("nombres"));
    public static Target INPUT_APELLIDOS = Target.the("Campo de apellidos")
            .located(By.id("apellidos"));
    public static Target INPUT_DIRECCION = Target.the("Campo de direccion")
            .located(By.id("direccion"));
    public static Target INPUT_NUMTEL = Target.the("Campo de numero de telefono")
            .located(By.id("num_tel"));
    public static Target INPUT_ROL = Target.the("Campo desplegable de Rol")
            .located(By.id("rol_id"));
    public static Target BTN_ENVIAR = Target.the("Boton de enviar")
            .located(By.id("enviar"));
    public static final Target COLUMNA_APELLIDO = Target.the("columna de apellidos")
            .locatedBy("h5.fw-bold.mb-2 span.apellido");

}
