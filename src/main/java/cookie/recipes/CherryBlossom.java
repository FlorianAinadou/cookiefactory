package main.java.cookie.recipes;

import main.java.cookie.Cookie;
import main.java.cookie.parameters.*;

import java.util.ArrayList;

/**
 * @author Lydia BARAUKOVA
 */
public class CherryBlossom extends Cookie {

    public CherryBlossom() {
        super(Dough.cherryJam, Cooking.chewy, Flavour.cherry, Mix.topped, new ArrayList<>(), 0.23);
        toppings.add(Topping.cherrySyrup);
    }
}
