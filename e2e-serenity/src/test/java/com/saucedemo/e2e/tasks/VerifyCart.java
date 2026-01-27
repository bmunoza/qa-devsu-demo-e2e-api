package com.saucedemo.e2e.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static com.saucedemo.e2e.tasks.AddProducts.SELECTED_PRODUCTS;
import static com.saucedemo.e2e.userInterfaces.InventoryPage.CART_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import com.saucedemo.e2e.questions.CartProductNames;


public class VerifyCart implements Task {

    public static VerifyCart matchesRememberedProducts() {
        return instrumented(VerifyCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> expected = actor.recall(SELECTED_PRODUCTS);

        actor.attemptsTo(
                Click.on(CART_LINK),
                Ensure.thatTheListOf(CartProductNames.displayed()).containsElementsFrom(expected)
        );
    }
}
