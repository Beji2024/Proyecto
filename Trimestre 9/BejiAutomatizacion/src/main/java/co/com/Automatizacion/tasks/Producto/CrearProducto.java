package co.com.Automatizacion.tasks.Producto;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.interactions.ScrollBottom;
import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.models.Usuarios.DatosRegistro;
import co.com.Automatizacion.userinterface.Productos.Producto;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static co.com.Automatizacion.userinterface.Productos.Producto.CAMPO_NOMBRE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearProducto implements Task {


    private List<DatosProducto> datos;
    public CrearProducto(List<DatosProducto> datos) {
        this.datos = datos;
    }

    public static CrearProducto crearProducto(List<DatosProducto> datos) {
        return Instrumented.instanceOf(CrearProducto.class).withProperties(datos);
    }
    Random rand = new Random();
    int numero = rand.nextInt(1000);

    @Override
    public <T extends Actor> void performAs(T actor) {


        String rutaImagen = Paths.get("src/test/resources/Imagenes/" + datos.get(0).getImagen())
                .toAbsolutePath().toString();
        File archivo = new File(rutaImagen);
        if (!archivo.exists()) {
            throw new RuntimeException("No se encontró la imagen en: " + rutaImagen);
        }

        actor.attemptsTo(
                Esperar.segundos(2),
                Click.on(Producto.BTN_NUEVOPRODUCTO),
                Click.on(CAMPO_NOMBRE),
                Enter.theValue(datos.get(0).getNombreProducto()+numero).into(CAMPO_NOMBRE),
                SelectFromOptions.byVisibleText(datos.get(0).getCategoria()).from(Producto.CAMPO_CATEGORIA),
                SelectFromOptions.byVisibleText(datos.get(0).getSubcategoria()).from(Producto.CAMPO_SUBCATEGORIA),
                Enter.theValue(String.valueOf(datos.get(0).getCantidad())).into(Producto.CAMPO_CANTIDAD),
                Enter.theValue(String.valueOf(datos.get(0).getTalla())).into(Producto.CAMPO_TALLA),
                Enter.theValue(String.valueOf(datos.get(0).getPrecioVenta())).into(Producto.CAMPO_PRECIO_VENTA),
                Enter.theValue(String.valueOf(datos.get(0).getPrecioCompra())).into(Producto.CAMPO_PRECIO_COMPRA),
                Enter.theValue(datos.get(0).getMaterial()).into(Producto.CAMPO_MATERIAL),
                Enter.theValue(datos.get(0).getColor()).into(Producto.CAMPO_COLOR),
                Enter.keyValues(rutaImagen).into(Producto.CAMPO_IMAGEN),
                Click.on(Producto.BTN_GUARDAR),
                Esperar.segundos(3)
        );
        theActorInTheSpotlight().remember(RegistroVariable.producto.toString(), datos.get(0).getNombreProducto() + numero);
    }
}


