package com.saucedemo.e2e.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target USERNAME = Target.the("username field").locatedBy("#user-name");
    public static final Target PASSWORD = Target.the("password field").locatedBy("#password");
    public static final Target LOGIN_BTN = Target.the("login button").locatedBy("#login-button");
}
