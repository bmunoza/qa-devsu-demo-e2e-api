package com.saucedemo.e2e.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.e2e.userInterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private final String user;
    private final String pass;

    public Login(String user, String pass) { this.user = user; this.pass = pass; }

    public static Login withCredentials(String user, String pass){
        return instrumented(Login.class, user, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(USERNAME),
                Enter.theValue(pass).into(PASSWORD),
                Click.on(LOGIN_BTN)
        );
    }
}
