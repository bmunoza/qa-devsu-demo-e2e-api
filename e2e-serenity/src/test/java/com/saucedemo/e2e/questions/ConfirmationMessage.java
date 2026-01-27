package com.saucedemo.e2e.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.e2e.userInterfaces.CheckputPage.CONFIRMATION;

public class ConfirmationMessage {
    public static Question<String> text() {
        return  actor -> Text.of(CONFIRMATION)
                .answeredBy(actor);
    }
}
