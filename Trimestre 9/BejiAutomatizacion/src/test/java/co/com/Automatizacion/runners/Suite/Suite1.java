package co.com.Automatizacion.runners.Suite;


import co.com.Automatizacion.runners.Proveedor.EditarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.EliminarProveedorRunner;
import co.com.Automatizacion.runners.Proveedor.RegistrarProveedorRunner;
import co.com.Automatizacion.runners.Usuarios.EditarUsuarioRunner;
import co.com.Automatizacion.runners.Usuarios.EliminarUsuarioRunner;
import co.com.Automatizacion.runners.Usuarios.RegistrarUsuarioRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegistrarUsuarioRunner.class,
        EditarUsuarioRunner.class,
        EliminarUsuarioRunner.class,
        RegistrarProveedorRunner.class,
        EditarProveedorRunner.class,
        EliminarProveedorRunner.class


})
public class Suite1 {
}
