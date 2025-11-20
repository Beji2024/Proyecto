package co.com.Automatizacion.runners.Productos;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Productos/EditarProducto.feature",
        glue = "co.com.Automatizacion.stepsdefinitions",
<<<<<<< HEAD
=======
        plugin = {"pretty", "html:target/cucumber-reports"},
>>>>>>> 18e8930b7b9e2bfa3724a8a7e49dfff8973d0548
        snippets = SnippetType.CAMELCASE
)
public class EditarProductoRunner {
}
