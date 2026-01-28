package com.saucedemo.e2e.stepDefinitions;


import com.saucedemo.e2e.questions.ConfirmationMessage;
import com.saucedemo.e2e.tasks.AddProducts;
import com.saucedemo.e2e.tasks.Checkout;
import com.saucedemo.e2e.tasks.Login;
import com.saucedemo.e2e.tasks.VerifyCart;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;


import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class PurchaseStepDefinitions {

    @Given("Brayan inicia sesion en SauceDemo con usuario {string} y contrasena {string}")
    public void brayanIniciaSesionEnSauceDemoConUsuarioYContrasena(String user, String pass) {
        theActorCalled("Brayan").attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                Login.withCredentials(user, pass));
    }


    @When("agrega productos al carrito")
    public void addTwoProducts(DataTable table) {
        List<String> products = table.asList();
        theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(products),
                VerifyCart.matchesRememberedProducts()
        );
    }

    @And("completa el formulario de compra con nombre {string} apellido {string} y zip {string}")
    public void fillCheckout(String first, String last, String zip) {
        theActorInTheSpotlight().attemptsTo(Checkout.fillForm(first, last, zip));
    }

    @Then("finaliza la compra y valida el mensaje {string}")
    public void validateMessage(String expected) {
        theActorInTheSpotlight().should(seeThat(ConfirmationMessage.text(), containsStringIgnoringCase(expected)));
    }
}
