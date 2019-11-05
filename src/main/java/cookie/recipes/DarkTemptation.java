package main.java.cookie.recipes;

import main.java.cookie.Cookie;
import main.java.cookie.parameters.*;

import java.util.ArrayList;

/**
 * @author Lydia BARAUKOVA
 */
public class DarkTemptation extends Cookie {

    public DarkTemptation() {
        super(Dough.chocolate, Cooking.crunchy, Flavour.chocolate, Mix.mixed, new ArrayList<>(), 0.21);
        toppings.add(Topping.darkChocolate);
    }
}
