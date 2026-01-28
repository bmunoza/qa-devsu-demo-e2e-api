package com.saucedemo.e2e.tasks;


import static com.saucedemo.e2e.userInterfaces.CheckputPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Checkout implements Task {
    private final String first, last, zip;

    public Checkout(String first, String last, String zip) {
        this.first = first; this.last = last; this.zip = zip;
    }

    public static Checkout fillForm(String first, String last, String zip) {
        return instrumented(Checkout.class, first, last, zip);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHECKOUT_BTN),
                Enter.theValue(first).into(FIRST_NAME),
                Enter.theValue(last).into(LAST_NAME),
                Enter.theValue(zip).into(POSTAL_CODE),
                Click.on(CONTINUE_BTN),
                Click.on(FINISH_BTN)
        );
    }
}
