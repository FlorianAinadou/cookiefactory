package cookie.recipes;

import cookie.Cookie;
import cookie.parameters.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Chocolala extends Cookie {


    public Chocolala() {
        super(CookieName.chocolala.toString(), Dough.chocolate, Cooking.chewy, Flavour.chocolate, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.milkChocolate)), 0.25);
    }


}
