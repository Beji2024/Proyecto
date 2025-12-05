package co.com.Automatizacion.runners.Suite;


import co.com.Automatizacion.runners.Productos.CrearProductoRunner;
import co.com.Automatizacion.runners.Productos.EditarProductoRunner;
import co.com.Automatizacion.runners.Productos.EliminarProductoRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CrearProductoRunner.class,
        EditarProductoRunner.class,
        EliminarProductoRunner.class
})
public class Suite2 {
}
