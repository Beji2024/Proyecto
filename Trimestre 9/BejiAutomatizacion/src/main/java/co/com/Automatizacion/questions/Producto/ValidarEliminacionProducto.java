package co.com.Automatizacion.questions.Producto;

import co.com.Automatizacion.userinterface.Productos.Producto;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

import java.util.List;

public class ValidarEliminacionProducto implements Question<Boolean> {

    private final String nombreProducto;

    public ValidarEliminacionProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static ValidarEliminacionProducto noExiste(String nombreProducto) {
        return new ValidarEliminacionProducto(nombreProducto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        List<WebElementFacade> filas = Producto.FILAS_TABLA.resolveAllFor(actor);

        // Si la tabla queda vacía → fue eliminado
        if (filas.isEmpty()) {
            return true;
        }

        // Obtener la última fila
        WebElementFacade ultimaFila = filas.get(filas.size() - 1);

        // Tomar el nombre de la primera celda
        String ultimoProducto = ultimaFila
                .findElement(Producto.NOMBRE_PRODUCTO_EN_FILA)
                .getText()
                .trim();

        // Comparar con el nombre eliminado
        return !ultimoProducto.equalsIgnoreCase(nombreProducto);
    }
}