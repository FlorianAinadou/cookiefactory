package api;

import model.Discount;
import model.RecipeCookie;
import model.cookie.CookieComposant;
import model.cookie.Recipe;
import model.cookie.ingredients.Const;
import model.cookie.ingredients.Dough;
import model.cookie.ingredients.Flavour;
import model.cookie.ingredients.Topping;
import model.cookie.parameters.CookieName;
import model.cookie.parameters.Cooking;
import model.cookie.parameters.Mix;
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

    static Map<String, RecipeCookie> generateCookieRecipes() {
        return new HashMap<String, RecipeCookie>(RECIPES_COOKIE);
    }

    static Map<String, CookieComposant> generateCookieDough() {
        return new HashMap<String, CookieComposant>(DOUGH_COOKIE);
    }

    static Map<String, CookieComposant> generateCookieFlavour() {
        return new HashMap<String, CookieComposant>(FLAVOUR_COOKIE);
    }

    static Map<String, CookieComposant> generateCookieTopping() {
        return new HashMap<String, CookieComposant>(TOPPING_COOKIE);
    }

    static Map<String, CookieComposant> generateCookieCooking() {
        return new HashMap<String, CookieComposant>(COOKING_COOKIE);
    }

    static Map<String, CookieComposant> generateCookieMix() {
        return new HashMap<String, CookieComposant>(MIX_COOKIE);
    }

    static Map<Customer, List<Discount>> generateDiscounts() {
        return new HashMap<Customer, List<Discount>>(DISCOUNTS);
    }

    static Map<String, Discount> getShopDiscounts() {
        return new HashMap<String, Discount>(SHOP_DISCOUNTS);
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



    private static Map<String, CookieComposant> DOUGH_COOKIE = new HashMap<String, CookieComposant>() {
        {
            put("Plain", new CookieComposant(Const.TYPE_DOUGH, "Plain", 0.05f));
            put("Chocolate", new CookieComposant(Const.TYPE_DOUGH, "Chocolate", 0.12f));
            put("Peanut butter", new CookieComposant(Const.TYPE_DOUGH, "Peanut butter", 0.10f));
            put("Oatmeal", new CookieComposant(Const.TYPE_DOUGH, "Oatmeal", 0.08f));
            put("Cherry jam", new CookieComposant(Const.TYPE_DOUGH, "Cherry jam", 0.15f));
        }
    };
    private static Map<String, CookieComposant> FLAVOUR_COOKIE = new HashMap<String, CookieComposant>() {
        {
            put("Vanilla", new CookieComposant(Const.TYPE_FLAVOUR, "Vanilla", 0.05f));
            put("Cinnamon", new CookieComposant(Const.TYPE_FLAVOUR, "Cinnamon", 0.12f));
            put("Chili", new CookieComposant(Const.TYPE_FLAVOUR, "Chili", 0.10f));
            put("Chocolate", new CookieComposant(Const.TYPE_FLAVOUR, "Chocolate", 0.08f));
            put("Cherry", new CookieComposant(Const.TYPE_FLAVOUR, "Cherry", 0.15f));
        }
    };
    private static Map<String, CookieComposant> TOPPING_COOKIE = new HashMap<String, CookieComposant>() {
        {
            put("White chocolate", new CookieComposant(Const.TYPE_TOPPING, "White chocolate", 0.05f));
            put("Milk chocolate", new CookieComposant(Const.TYPE_TOPPING, "Milk chocolate", 0.12f));
            put("Dark chocolate", new CookieComposant(Const.TYPE_TOPPING, "Dark chocolate", 0.10f));
            put("Cherry syrup", new CookieComposant(Const.TYPE_TOPPING, "Cherry syrup", 0.08f));
            put("M&Ms", new CookieComposant(Const.TYPE_TOPPING, "M&Ms", 0.15f));
        }
    };
    private static Map<String, CookieComposant> COOKING_COOKIE = new HashMap<String, CookieComposant>() {
        {
            put("Crunchy", new CookieComposant(Const.TYPE_COOKING, "Crunchy"));
            put("Chewy", new CookieComposant(Const.TYPE_COOKING, "Chewy"));
        }
    };
    private static Map<String, CookieComposant> MIX_COOKIE = new HashMap<String, CookieComposant>() {
        {
            put("Mixed", new CookieComposant(Const.TYPE_MIX, "Mixed"));
            put("Topped", new CookieComposant(Const.TYPE_MIX, "Topped"));
        }
    };

    private static Map<RegisteredCustomer, List<Discount>> DISCOUNTS = new HashMap<RegisteredCustomer, List<Discount>>() {{
        put((RegisteredCustomer) FAKE_USERS.get(0), Arrays.asList(new Discount(0.90f, "PROMO10")));
    }};

    private static Map<String, Discount> SHOP_DISCOUNTS = new HashMap<String, Discount>() {{
        put("LOYALTY_PROGRAM", new Discount(0.1f, "LOYALTY_PROGRAM"));
        //put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
        //put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
    }};

    private static Map<String, RecipeCookie> RECIPES_COOKIE = new HashMap<String, RecipeCookie>() {{
        put("CherryBlossom", new RecipeCookie("CherryBlossom", new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Cherry jam"), COOKING_COOKIE.get("Chewy"), FLAVOUR_COOKIE.get("Cherry"), MIX_COOKIE.get("Topped"), TOPPING_COOKIE.get("Cherry syrup")))));
        put("Chocolala", new RecipeCookie("Chocolala", new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Chocolate"), COOKING_COOKIE.get("Crunchy"), FLAVOUR_COOKIE.get("Chocolate"), MIX_COOKIE.get("Topped"), TOPPING_COOKIE.get("Milk chocolate")))));
        put("DarkTemptation", new RecipeCookie("DarkTemptation", new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Chocolate"), COOKING_COOKIE.get("Crunchy"), FLAVOUR_COOKIE.get("Chocolate"), MIX_COOKIE.get("Mixed"), TOPPING_COOKIE.get("Dark chocolate")))));
    }};

}
