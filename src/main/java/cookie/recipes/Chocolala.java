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
public class Chocolala extends Cookie {


    public Chocolala() {
        super(CookieName.chocolala.toString(), Dough.chocolate, Cooking.chewy, Flavour.chocolate, Mix.topped, new ArrayList<Topping>(), 0.25);
        toppings.add(Topping.milkChocolate);
    }


}
