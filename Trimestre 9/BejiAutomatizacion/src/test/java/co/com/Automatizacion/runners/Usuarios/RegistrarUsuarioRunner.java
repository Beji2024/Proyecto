package co.com.Automatizacion.runners.Usuarios;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Usuarios/registrar_usuario.feature",
        glue = {"co.com.Automatizacion.stepsdefinitions", "co.com.Automatizacion.utils.hooks"},
<<<<<<< HEAD
=======
        plugin = {"pretty","html:target/cucumber-reports"},
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
        snippets = SnippetType.CAMELCASE
)
public class RegistrarUsuarioRunner {
}
