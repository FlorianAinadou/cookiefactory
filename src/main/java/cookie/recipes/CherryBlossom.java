package cookie.recipes;

import cookie.Cookie;
import cookie.ingredients.Dough;
import cookie.ingredients.Flavour;
import cookie.ingredients.Topping;
import cookie.parameters.*;

import java.util.ArrayList;

/**
 * @author Lydia BARAUKOVA
 */
public class CherryBlossom extends Cookie {


    public CherryBlossom() {
        super(CookieName.cherryBlossom.toString(), Dough.cherryJam, Cooking.chewy, Flavour.cherry, Mix.topped, new ArrayList<>(), 0.23);
        toppings.add(Topping.cherrySyrup);
    }
}
