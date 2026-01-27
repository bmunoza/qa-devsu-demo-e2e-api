package com.saucedemo.e2e.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

import static com.saucedemo.e2e.userInterfaces.CheckputPage.CART_ITEM_NAMES;

public class CartProductNames implements Question<List<String>> {
    public static CartProductNames displayed() {
        return new CartProductNames();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return CART_ITEM_NAMES.resolveAllFor(actor)
                .stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

}
