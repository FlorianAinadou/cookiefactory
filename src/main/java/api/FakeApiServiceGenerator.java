package api;

import model.Discount;
import model.Recipe;
import model.cookie.CookieComponent;
import model.Place;
import model.Shop;
import model.customer.Customer;
import model.customer.RegisteredCustomer;
import model.customer.UnregisteredCustomer;
import utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 */
public abstract class FakeApiServiceGenerator {

    static List<Customer> generateUsers() {
        return new ArrayList<>(FAKE_USERS);
    }
    static Map<String, Recipe> generateCookieRecipes() {
        return new HashMap<>(RECIPES_COOKIE);
    }
    static Map<String, CookieComponent> generateCookieDough() {
        return new HashMap<>(DOUGH_COOKIE);
    }
    static Map<String, CookieComponent> generateCookieFlavour() { return new HashMap<>(FLAVOUR_COOKIE); }
    static Map<String, CookieComponent> generateCookieTopping() { return new HashMap<>(TOPPING_COOKIE); }
    static Map<String, CookieComponent> generateCookieCooking() { return new HashMap<>(COOKING_COOKIE); }
    static Map<String, CookieComponent> generateCookieMix() {
        return new HashMap<>(MIX_COOKIE);
    }
    static Map<Customer, ArrayList<Discount>> generateDiscounts() {
        return new HashMap<>(DISCOUNTS);
    }
    static List<Shop> generateShops() { return new ArrayList<>(FAKE_SHOPS);}

    static Map<String, Discount> getShopDiscounts() {
        return new HashMap<>(SHOP_DISCOUNTS);
    }

    private static List<Customer> FAKE_USERS = Arrays.asList(
            new RegisteredCustomer(0, "Paul", "Dupont", 20, "0612345678", "paul@gmail.com", "test"),
            new UnregisteredCustomer("Jean", "Pierre", "0612343678", "jean@gmail.com"),
            new UnregisteredCustomer("Pierre", "Martin", "0632345678", "pierre@gmail.com"),
            new UnregisteredCustomer("Alexis", "Blanchard", "0612345638", "alexis@gmail.com"),
            new UnregisteredCustomer("Alexandre", "Roman", "0612335678", "alexandre@gmail.com")
    );

    public static List<Customer> FAKE_USERS_RANDOM = Arrays.asList(
            new RegisteredCustomer(0, "Paul", "Dupont", 20, "0612345678", "paul@gmail.com", "test"),
            new UnregisteredCustomer("Jean", "Pierre", "0612343678", "jean@gmail.com"),
            new UnregisteredCustomer("Pierre", "Martin", "0632345678", "pierre@gmail.com"),
            new UnregisteredCustomer("Alexis", "Blanchard", "0612345638", "alexis@gmail.com"),
            new UnregisteredCustomer("Alexandre", "Roman", "0612335678", "alexandre@gmail.com")
    );

    private static SimpleDateFormat horaire = new SimpleDateFormat("HH:mm");

    public static List<Shop> FAKE_SHOPS;

    static {
        try {
            FAKE_SHOPS = Arrays.asList(
                    new Shop(0,"The Place to Be Sophia"," 200 Avenue Roumanille, 06410 Biot", Place.Biot, horaire.parse("08:00"), horaire.parse("18:30"),0.5),
                    new Shop(1,"The Place to Be Nice"," 9 Rue Alberti, 06000 Nice", Place.Nice, horaire.parse("09:00"), horaire.parse("18:30"),0.05),
                    new Shop(2,"The Place to Be Cannes","39 Rue Hoche, 06400 Cannes", Place.Cannes, horaire.parse("09:00"), horaire.parse("19:00"),0.1)

                );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    private static Map<String, CookieComponent> DOUGH_COOKIE = new HashMap<String, CookieComponent>() {
        {
            put(Lib.Dough.PLAIN, new CookieComponent(Lib.ComponentType.DOUGH, Lib.Dough.PLAIN, 0.05f));
            put(Lib.Dough.CHOCOLATE, new CookieComponent(Lib.ComponentType.DOUGH, Lib.Dough.CHOCOLATE, 0.12f));
            put(Lib.Dough.PEANUT_BUTTER, new CookieComponent(Lib.ComponentType.DOUGH, Lib.Dough.PEANUT_BUTTER, 0.10f));
            put(Lib.Dough.OATMEAL, new CookieComponent(Lib.ComponentType.DOUGH, Lib.Dough.OATMEAL, 0.08f));
            put(Lib.Dough.CHERRY_JAM, new CookieComponent(Lib.ComponentType.DOUGH, Lib.Dough.CHERRY_JAM, 0.15f));
        }
    };
    private static Map<String, CookieComponent> FLAVOUR_COOKIE = new HashMap<String, CookieComponent>() {
        {
            put(Lib.Flavour.VANILLA, new CookieComponent(Lib.ComponentType.FLAVOUR, Lib.Flavour.VANILLA, 0.05f));
            put(Lib.Flavour.CINNAMON, new CookieComponent(Lib.ComponentType.FLAVOUR, Lib.Flavour.CINNAMON, 0.12f));
            put(Lib.Flavour.CHILI, new CookieComponent(Lib.ComponentType.FLAVOUR, Lib.Flavour.CHILI, 0.10f));
            put(Lib.Flavour.CHOCOLATE, new CookieComponent(Lib.ComponentType.FLAVOUR, Lib.Flavour.CHOCOLATE, 0.08f));
            put(Lib.Flavour.CHERRY, new CookieComponent(Lib.ComponentType.FLAVOUR, Lib.Flavour.CHERRY, 0.15f));
        }
    };
    private static Map<String, CookieComponent> TOPPING_COOKIE = new HashMap<String, CookieComponent>() {
        {
            put(Lib.Topping.WHITE_CHOCOLATE, new CookieComponent(Lib.ComponentType.TOPPING, Lib.Topping.WHITE_CHOCOLATE, 0.05f));
            put(Lib.Topping.MILK_CHOCOLATE, new CookieComponent(Lib.ComponentType.TOPPING, Lib.Topping.MILK_CHOCOLATE, 0.12f));
            put(Lib.Topping.DARK_CHOCOLATE, new CookieComponent(Lib.ComponentType.TOPPING, Lib.Topping.DARK_CHOCOLATE, 0.10f));
            put(Lib.Topping.CHERRY_SYRUP, new CookieComponent(Lib.ComponentType.TOPPING, Lib.Topping.CHERRY_SYRUP, 0.08f));
            put(Lib.Topping.MNMS, new CookieComponent(Lib.ComponentType.TOPPING, Lib.Topping.MNMS, 0.15f));
        }
    };
    private static Map<String, CookieComponent> COOKING_COOKIE = new HashMap<String, CookieComponent>() {
        {
            put(Lib.Cooking.CRUNCHY, new CookieComponent(Lib.ComponentType.COOKING, Lib.Cooking.CRUNCHY));
            put(Lib.Cooking.CHEWY, new CookieComponent(Lib.ComponentType.COOKING, Lib.Cooking.CHEWY));
        }
    };
    private static Map<String, CookieComponent> MIX_COOKIE = new HashMap<String, CookieComponent>() {
        {
            put(Lib.Mix.MIXED, new CookieComponent(Lib.ComponentType.MIX, Lib.Mix.MIXED));
            put(Lib.Mix.TOPPED, new CookieComponent(Lib.ComponentType.MIX, Lib.Mix.TOPPED));
        }
    };

    private static Map<RegisteredCustomer, ArrayList<Discount>> DISCOUNTS = new HashMap<RegisteredCustomer, ArrayList<Discount>>() {{
        put((RegisteredCustomer)FAKE_USERS.get(0), new ArrayList<>(Collections.singletonList(new Discount(0.10f, "PROMO10"))));
    }};

    private static HashMap<String , Discount> SHOP_DISCOUNTS = new HashMap<String, Discount>(){{
        put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
        //put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
        //put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
    }};

    private static Map<String, Recipe> RECIPES_COOKIE = new HashMap<String, Recipe>() {{
        put(Lib.CookieName.CHERRY_BLOSSOM, new Recipe(Lib.CookieName.CHERRY_BLOSSOM, new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Cherry jam"), COOKING_COOKIE.get("Chewy"), FLAVOUR_COOKIE.get("Cherry"), MIX_COOKIE.get("Topped"), TOPPING_COOKIE.get("Cherry syrup")))));
        put(Lib.CookieName.CHOCOLALA, new Recipe(Lib.CookieName.CHOCOLALA, new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Chocolate"), COOKING_COOKIE.get("Crunchy"), FLAVOUR_COOKIE.get("Chocolate"), MIX_COOKIE.get("Topped"), TOPPING_COOKIE.get("Milk chocolate")))));
        put(Lib.CookieName.DARK_TEMPTATION, new Recipe(Lib.CookieName.DARK_TEMPTATION, new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Chocolate"), COOKING_COOKIE.get("Crunchy"), FLAVOUR_COOKIE.get("Chocolate"), MIX_COOKIE.get("Mixed"), TOPPING_COOKIE.get("Dark chocolate")))));
    }};

}
