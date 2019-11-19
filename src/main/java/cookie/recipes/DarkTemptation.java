package cookie.recipes;

import cookie.Cookie;
import cookie.parameters.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class DarkTemptation extends Cookie {

    public DarkTemptation() {
        super(CookieName.darkTemptation.toString(), Dough.chocolate, Cooking.crunchy, Flavour.chocolate, Mix.mixed, new ArrayList<>(Collections.singletonList(Topping.darkChocolate)), 0.21);
    }
}
