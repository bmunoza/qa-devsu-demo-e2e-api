package com.saucedemo.e2e.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {
    public static final Target PRODUCT = Target.the("product add to cart button").locatedBy("//div[@class='inventory_item' and .//div[text()='{0}']]//button");
    public static final Target CART_LINK = Target.the("cart button").locatedBy(".shopping_cart_link");
}
