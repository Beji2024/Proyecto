package co.com.Automatizacion.tasks.Producto;

import co.com.Automatizacion.interactions.Esperar;
import co.com.Automatizacion.models.Producto.DatosProducto;
import co.com.Automatizacion.userinterface.Productos.Producto;
import co.com.Automatizacion.utils.hooks.Usuarios.RegistroVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EditarProducto implements Task {

    Random rand = new Random();
    int numero = rand.nextInt(1000);

    private List<DatosProducto> datos;
    public EditarProducto(List<DatosProducto>datos) {this.datos = datos;}

    public static EditarProducto editarProducto(List<DatosProducto> datos) {
        return Instrumented.instanceOf(EditarProducto.class).withProperties(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(Producto.BTN_EDITAR_ULTIMO),

                Clear.field(Producto.CAMPO_NOMBRE),
                Enter.theValue(datos.get(0).getNombreProducto()+numero).into(Producto.CAMPO_NOMBRE),

                SelectFromOptions.byVisibleText(datos.get(0).getCategoria()).from(Producto.CAMPO_CATEGORIA),
                SelectFromOptions.byVisibleText(datos.get(0).getSubcategoria()).from(Producto.CAMPO_SUBCATEGORIA),

                Clear.field(Producto.CAMPO_CANTIDAD),
                Enter.theValue(String.valueOf(datos.get(0).getCantidad())).into(Producto.CAMPO_CANTIDAD),

                Clear.field(Producto.CAMPO_TALLA),
                Enter.theValue(datos.get(0).getTalla()).into(Producto.CAMPO_TALLA),

                Clear.field(Producto.CAMPO_PRECIO_VENTA),
                Enter.theValue(String.valueOf(datos.get(0).getPrecioVenta())).into(Producto.CAMPO_PRECIO_VENTA),

                Clear.field(Producto.CAMPO_PRECIO_COMPRA),
                Enter.theValue(String.valueOf(datos.get(0).getPrecioCompra())).into(Producto.CAMPO_PRECIO_COMPRA),

                Clear.field(Producto.CAMPO_MATERIAL),
                Enter.theValue(datos.get(0).getMaterial()).into(Producto.CAMPO_MATERIAL),

                Clear.field(Producto.CAMPO_COLOR),
                Enter.theValue(datos.get(0).getColor()).into(Producto.CAMPO_COLOR),

                Click.on(Producto.BTN_GUARDAR),
                Esperar.segundos(3)
        );
        theActorInTheSpotlight().remember(RegistroVariable.producto.toString(), datos.get(0).getNombreProducto() + numero);
    }
}

