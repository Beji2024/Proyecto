package co.com.Automatizacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/registrar_usuario.feature",
        glue = {"co.com.Automatizacion.stepsdefinitions", "co.com.Automatizacion.utils.hooks"},
        snippets = SnippetType.CAMELCASE
)
public class RegistrarUsuarioRunner {
}
