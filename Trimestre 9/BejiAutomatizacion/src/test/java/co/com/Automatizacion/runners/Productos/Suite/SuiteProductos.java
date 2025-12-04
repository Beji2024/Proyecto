package co.com.Automatizacion.runners.Productos.Suite;
import co.com.Automatizacion.runners.Productos.CrearProductoRunner;
import co.com.Automatizacion.runners.Productos.EditarProductoRunner;
import co.com.Automatizacion.runners.Productos.EliminarProductoRunner;
import co.com.Automatizacion.runners.Proveedor.RegistrarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.EditarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.EliminarProveedorRunner;
import co.com.Automatizacion.runners.Usuarios.RegistrarUsuarioRunner;
import co.com.Automatizacion.runners.Usuarios.EditarUsuarioRunner;
import co.com.Automatizacion.runners.Usuarios.EliminarUsuarioRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CrearProductoRunner.class,
        EditarProductoRunner.class,
        EliminarProductoRunner.class,

})
public class SuiteProductos {
}
