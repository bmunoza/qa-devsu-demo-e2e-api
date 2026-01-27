package com.saucedemo.e2e.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckputPage {
    public static final Target CHECKOUT_BTN = Target.the("checkout button").locatedBy("#checkout");
    public static final Target CART_ITEM_NAMES = Target.the("cart products name").locatedBy("//*[@data-test='inventory-item-name']");

    public static final Target FIRST_NAME = Target.the("first name field").locatedBy("#first-name");
    public static final Target LAST_NAME = Target.the("last name field").locatedBy("#last-name");
    public static final Target POSTAL_CODE = Target.the("postal code field").locatedBy("#postal-code");
    public static final Target CONTINUE_BTN = Target.the("continue field").locatedBy("#continue");

    public static final Target FINISH_BTN = Target.the("finish field").locatedBy("#finish");
    public static final Target CONFIRMATION = Target.the("confirmation message").locatedBy(".complete-header");
}
