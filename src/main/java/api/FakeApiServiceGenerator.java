package api;

import cookie.Cookie;
import cookie.parameters.*;
import customer.Customer;
import customer.UnregisteredCustomer;

import java.util.*;

/**
 * @author Virgile FANTAUZZI
 */


public abstract class FakeApiServiceGenerator {


    static List<Customer> generateUsers() {
        return new ArrayList<>(FAKE_USERS);
    }
    static Map<String, Cookie> generateCookieRecipes() {
        return new HashMap<String, Cookie>(RECIPES_COOKIE);
    }

    public static List<Customer> FAKE_USERS = Arrays.asList(
            new UnregisteredCustomer("Paul", "Dupont", "0612345678", "paul@gmail.com"),
            new UnregisteredCustomer("Jean", "Pierre", "0612343678", "jean@gmail.com"),
            new UnregisteredCustomer("Pierre", "Martin", "0632345678", "pierre@gmail.com"),
            new UnregisteredCustomer("Alexis", "Blanchard", "0612345638", "alexis@gmail.com"),
            new UnregisteredCustomer("Alexandre", "Roman", "0612335678", "alexandre@gmail.com")
    );

    public static List<Customer> FAKE_USERS_RANDOM = Arrays.asList(
            new UnregisteredCustomer("Paul", "Dupont", "0612345678", "paul@gmail.com"),
            new UnregisteredCustomer("Jean", "Pierre", "0612343678", "jean@gmail.com"),
            new UnregisteredCustomer("Pierre", "Martin", "0632345678", "pierre@gmail.com"),
            new UnregisteredCustomer("Alexis", "Blanchard", "0612345638", "alexis@gmail.com"),
            new UnregisteredCustomer("Alexandre", "Roman", "0612335678", "alexandre@gmail.com")
    );


    public static Map<String, Cookie> RECIPES_COOKIE = new HashMap<String, Cookie>() {{
        put("CherryBlossom", new Cookie(CookieName.cherryBlossom.toString(), Dough.cherryJam, Cooking.chewy, Flavour.cherry, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.cherrySyrup)), 0.23));
        put("Chocolala", new Cookie(CookieName.chocolala.toString(), Dough.chocolate, Cooking.chewy, Flavour.chocolate, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.milkChocolate)), 0.25));
        put("DarkTemptation", new Cookie(CookieName.darkTemptation.toString(), Dough.chocolate, Cooking.crunchy, Flavour.chocolate, Mix.mixed, new ArrayList<>(Collections.singletonList(Topping.darkChocolate)), 0.21));
    }};

}
