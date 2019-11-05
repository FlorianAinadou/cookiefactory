package main.java.cookie.recipes;

import main.java.cookie.Cookie;
import main.java.cookie.parameters.*;

import java.util.ArrayList;

/**
 * @author Lydia BARAUKOVA
 */
public class Chocolala extends Cookie {

    public Chocolala() {
        super(Dough.chocolate, Cooking.chewy, Flavour.chocolate, Mix.topped, new ArrayList<Topping>());
        toppings.add(Topping.milkChocolate);
    }
}
