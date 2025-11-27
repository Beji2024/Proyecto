package co.com.Automatizacion.runners.Usuarios.Suite;

import co.com.Automatizacion.runners.Usuarios.RegistrarUsuarioRunner;
import co.com.Automatizacion.runners.Usuarios.EditarUsuarioRunner;
import co.com.Automatizacion.runners.Usuarios.EliminarUsuarioRunner;
import  org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegistrarUsuarioRunner.class,
        EditarUsuarioRunner.class,
        EliminarUsuarioRunner.class,
})
public class SuiteUsuarios {
}
