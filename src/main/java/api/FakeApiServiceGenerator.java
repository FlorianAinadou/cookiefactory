package api;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import model.Discount;
import model.cookie.Cookie;
import model.cookie.Recipe;
import model.cookie.ingredients.Dough;
import model.cookie.ingredients.Flavour;
import model.cookie.ingredients.Topping;
import model.cookie.parameters.*;
import model.customer.Customer;
import model.customer.RegisteredCustomer;
import model.customer.UnregisteredCustomer;

import java.util.*;

/**
 * @author Virgile FANTAUZZI
 */


public abstract class FakeApiServiceGenerator {


    static List<Customer> generateUsers() {
        return new ArrayList<>(FAKE_USERS);
    }

    static Map<String, Recipe> generateCookieRecipes() {
        return new HashMap<String, Recipe>(RECIPES_COOKIE);
    }

    static Map<RegisteredCustomer, List<Discount>> generateDiscounts() {
        return new HashMap<RegisteredCustomer, List<Discount>>(DISCOUNTS);
    }

    private static List<Customer> FAKE_USERS = Arrays.asList(
            new RegisteredCustomer(0, "Paul", "Dupont", 20, "0612345678", "paul@gmail.com", "test"),
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


    private static Map<String, Recipe> RECIPES_COOKIE = new HashMap<String, Recipe>() {{
        put("CherryBlossom", new Recipe(CookieName.cherryBlossom.toString(), Dough.cherryJam, Cooking.chewy, Flavour.cherry, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.cherrySyrup))));
        put("Chocolala", new Recipe(CookieName.chocolala.toString(), Dough.chocolate, Cooking.chewy, Flavour.chocolate, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.milkChocolate))));
        put("DarkTemptation", new Recipe(CookieName.darkTemptation.toString(), Dough.chocolate, Cooking.crunchy, Flavour.chocolate, Mix.mixed, new ArrayList<>(Collections.singletonList(Topping.darkChocolate))));
    }};

    private static Map<RegisteredCustomer, List<Discount>> DISCOUNTS = new HashMap<RegisteredCustomer, List<Discount>>() {{
        put((RegisteredCustomer)FAKE_USERS.get(0), Arrays.asList(new Discount( 0.90f, "PROMO10")));
    }};

}
