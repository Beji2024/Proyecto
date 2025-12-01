package co.com.Automatizacion.userinterface.Usuarios;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RegistrarUsuario extends PageObject {

    public static Target BTN_USUARIO = Target.the("Boton de modulo usuarios")
            .located(By.id("usuarios"));
    public static Target BTN_NUEVO = Target.the("Boton para registro")
            .located(By.id("nuevo"));
    public static Target INPUT_NUMDOCUMENTO = Target.the("Numero de documento")
            .located(By.id("num_doc"));
    public static Target INPUT_NOMBRES = Target.the("Nombres")
            .located(By.id("nombres"));
    public static Target INPUT_APELLIDOS = Target.the("Apellidos")
            .located(By.id("apellidos"));
    public static Target INPUT_DIRECCION = Target.the("Direccion")
            .located(By.id("direccion"));
    public static Target INPUT_CORREO = Target.the("Correo electronico")
            .located(By.id("email"));
    public static Target INPUT_TELEFONO = Target.the("Numero de telefono")
            .located(By.id("num_tel"));
    public static Target INPUT_FECHA = Target.the("Fecha de nacimiento")
            .located(By.id("fec_nac"));
    public static Target INPUT_CLAVE = Target.the("Contraseña")
            .located(By.id("password"));
    public static Target INPUT_TIPODOC = Target.the("Tipo de documento")
            .located(By.id("tipodoc_id"));
    public static Target INPUT_ROL = Target.the("Rol del usuario")
            .located(By.id("rol_id"));
    public static Target BTN_ENVIAR = Target.the("Enviar formulario")
            .located(By.id("enviar"));
    public static Target BTN_SIGUIENTE = Target.the("Siguiente pagina boton")
            .located(By.id("siguiente"));
    public static final Target COLUMNA_DOCUMENTO = Target.the("columna de documentos")
            .locatedBy("//p[b[text()='Documento:']]");
}