package com.saucedemo.e2e.tasks;

import net.serenitybdd.screenplay.Task;

import static com.saucedemo.e2e.userInterfaces.InventoryPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.List;


public class AddProducts implements Task {
    public static final String SELECTED_PRODUCTS = "selectedProducts";
    private final List<String> productNames;

    public AddProducts(List<String> productNames) {
        this.productNames = productNames;
    }

    public static AddProducts toCart(List<String> productNames) {
        return instrumented(AddProducts.class, productNames);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(SELECTED_PRODUCTS, new ArrayList<>(productNames));
        for (String name : productNames) {
            actor.attemptsTo(
                    Click.on(PRODUCT.of(name))
            );
        }
    }
}
