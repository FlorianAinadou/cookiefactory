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
public class DarkTemptation extends Cookie {

    public DarkTemptation() {
        super(CookieName.darkTemptation.toString(), Dough.chocolate, Cooking.crunchy, Flavour.chocolate, Mix.mixed, new ArrayList<>(), 0.21);
        toppings.add(Topping.darkChocolate);
    }
}
