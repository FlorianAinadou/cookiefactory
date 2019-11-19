package cookie.recipes;

import cookie.Cookie;
import cookie.parameters.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class CherryBlossom extends Cookie {


    public CherryBlossom() {
        super(CookieName.cherryBlossom.toString(), Dough.cherryJam, Cooking.chewy, Flavour.cherry, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.cherrySyrup)), 0.23);
    }
}
