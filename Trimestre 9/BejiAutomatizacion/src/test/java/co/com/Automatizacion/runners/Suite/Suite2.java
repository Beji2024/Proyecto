package co.com.Automatizacion.runners.Suite;


import co.com.Automatizacion.tasks.Producto.CrearProducto;
import co.com.Automatizacion.tasks.Producto.EditarProducto;
import co.com.Automatizacion.tasks.Producto.EliminarProducto;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CrearProducto.class,
        EditarProducto.class,
        EliminarProducto.class

})
public class Suite2 {
}
