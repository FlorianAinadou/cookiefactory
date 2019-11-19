package cookie.recipes;

import cookie.Cookie;
import cookie.ingredients.Dough;
import cookie.ingredients.Flavour;
import cookie.ingredients.Topping;
import cookie.parameters.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class DarkTemptation extends Cookie {

    //Passer par l'api
    public DarkTemptation() {
        super(CookieName.darkTemptation.toString(), Dough.chocolate, Cooking.crunchy, Flavour.chocolate, Mix.mixed, new ArrayList<>(Collections.singletonList(Topping.darkChocolate)));
    }
}
