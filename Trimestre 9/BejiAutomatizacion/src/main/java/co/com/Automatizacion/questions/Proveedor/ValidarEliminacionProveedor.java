package co.com.Automatizacion.questions.Proveedor;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.List;

public class ValidarEliminacionProveedor implements Question<Boolean> {

    private final String nit;

    public ValidarEliminacionProveedor(String nit) {
        this.nit = nit;
    }

    public static ValidarEliminacionProveedor noExiste(String nit) {
        return new ValidarEliminacionProveedor(nit);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> elementos = BrowseTheWeb.as(actor)
                .findAll(By.xpath("//td[contains(text(),'" + nit + "')]"));

        return elementos.isEmpty();
    }
}

