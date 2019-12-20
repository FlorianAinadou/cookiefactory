package api;


import model.Order;
import model.Place;
import model.Recipe;
import model.Shop;
import model.consumables.CookieComponent;
import model.consumables.PackComposition;
import model.customer.Customer;
import model.customer.RegisteredCustomer;
import model.customer.UnregisteredCustomer;
import model.discount.Discount;
import utils.Lib;

import java.util.*;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 * @author Aldric Ducreux
 */
public abstract class FakeApiServiceGenerator {

    static List<Customer> generateCustomers() {
        List<Customer> c = new ArrayList<>(FAKE_REGISTERED_CUSTOMERS);
        c.addAll(FAKE_UNREGISTERED_CUSTOMERS);
        return c;
    }
    static List<Shop> generateShops() { return new ArrayList<>(FAKE_SHOPS); }
    static Map<String, Recipe> generateCookieRecipes() {
        return new HashMap<>(COOKIE_RECIPES);
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
    static Map<String, Discount> generateShopDiscounts() {
        return new HashMap<>(SHOP_DISCOUNTS);
    }
    static Map<String, HashMap<String, Integer>> generateStocks() {
        return new HashMap<>(STOCKS);
    }
    static ArrayList<PackComposition> generatePacksComposition(){ return new ArrayList<>(FAKE_PACKS);}

    static List<Customer> FAKE_REGISTERED_CUSTOMERS = Arrays.asList(
            new RegisteredCustomer(0, "Paul", "Dupont", 20, "0612345678", "paul@gmail.com", "test", 2000.0),
            new RegisteredCustomer(1, "Jean", "Pierre", 43, "0612343678", "jean@gmail.com", "test", 2000.0),
            new RegisteredCustomer(2, "Pierre", "Martin", 35, "0632345678", "pierre@gmail.com", "test", 2000.0)
    );
    static List<Customer> FAKE_UNREGISTERED_CUSTOMERS = Arrays.asList(
            new UnregisteredCustomer("Alexis", "Blanchard", "0612345638", "alexis@gmail.com", 2000.0),
            new UnregisteredCustomer("Alexandre", "Roman", "0612335678", "alexandre@gmail.com", 2000.0),
            new UnregisteredCustomer("Pauline", "Durand", "0645897556", "pauline@gmail.com", 2000.0)
    );

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

    private static Map<String, Recipe> COOKIE_RECIPES = new HashMap<String, Recipe>() {{
        put(Lib.CookieName.CHERRY_BLOSSOM, new Recipe(Lib.CookieName.CHERRY_BLOSSOM, 2.00, new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Cherry jam"), COOKING_COOKIE.get("Chewy"), FLAVOUR_COOKIE.get("Cherry"), MIX_COOKIE.get("Topped"), TOPPING_COOKIE.get("Cherry syrup")))));
        put(Lib.CookieName.CHOCOLALA, new Recipe(Lib.CookieName.CHOCOLALA, 2.00, new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Chocolate"), COOKING_COOKIE.get("Crunchy"), FLAVOUR_COOKIE.get("Chocolate"), MIX_COOKIE.get("Topped"), TOPPING_COOKIE.get("Milk chocolate")))));
        put(Lib.CookieName.DARK_TEMPTATION, new Recipe(Lib.CookieName.DARK_TEMPTATION, 2.00, new ArrayList<>(Arrays.asList(DOUGH_COOKIE.get("Chocolate"), COOKING_COOKIE.get("Crunchy"), FLAVOUR_COOKIE.get("Chocolate"), MIX_COOKIE.get("Mixed"), TOPPING_COOKIE.get("Dark chocolate")))));
    }};

    private static Map<String, Integer> STOCKS_SAMPLE = new HashMap<String, Integer>() {{
        put(Lib.Topping.CHERRY_SYRUP, 100);
        put(Lib.Topping.MILK_CHOCOLATE, 100);
        put(Lib.Topping.DARK_CHOCOLATE, 100);
        put(Lib.Topping.MNMS, 100);
        put(Lib.Topping.WHITE_CHOCOLATE, 100);

        put(Lib.Flavour.CHERRY, 100);
        put(Lib.Flavour.CHILI, 100);
        put(Lib.Flavour.CINNAMON, 100);
        put(Lib.Flavour.VANILLA, 100);

        put(Lib.Dough.CHERRY_JAM, 100);
        put(Lib.Dough.CHOCOLATE, 100);
        put(Lib.Dough.OATMEAL, 100);
        put(Lib.Dough.PEANUT_BUTTER, 100);
        put(Lib.Dough.PLAIN, 100);

        put(Lib.Drink.COCA_ZERO, 100);
        put(Lib.Drink.SPRITE, 100);

    }};


    private static Map<String, HashMap<String, Integer>> STOCKS = new HashMap<String, HashMap<String, Integer>>() {{
        put("SophiaCookies", new HashMap<>(STOCKS_SAMPLE));
        put("NiceCookies", new HashMap<>(STOCKS_SAMPLE));
        put("CannesCookies", new HashMap<>(STOCKS_SAMPLE));
    }};



    private static Map<RegisteredCustomer, ArrayList<Discount>> DISCOUNTS = new HashMap<RegisteredCustomer, ArrayList<Discount>>() {{
        put((RegisteredCustomer)FAKE_REGISTERED_CUSTOMERS.get(0), new ArrayList<>(Collections.singletonList(new Discount(0.10f, "PROMO10"))));
        put((RegisteredCustomer)FAKE_REGISTERED_CUSTOMERS.get(0), new ArrayList<>(Collections.singletonList(new Discount(0.05f, "CE_AMADEUS"))));
    }};

    private static HashMap<String , Discount> SHOP_DISCOUNTS = new HashMap<String, Discount>(){{
        put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM", 30));
        put("CE_AMADEUS",new Discount(0.05f, "CE_AMADEUS"));
        //put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
    }};


    static List<PackComposition> FAKE_PACKS;
    static {
        try {
            FAKE_PACKS = Arrays.asList(
                    new PackComposition(40, 15.0f),
                    new PackComposition(80, 25.0f),
                    new PackComposition(120, 35.0f)
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static List<Shop> FAKE_SHOPS = Arrays.asList(
            new Shop(0,"SophiaCookies"," 200 Avenue Roumanille, 06410 Biot", Place.Biot, 8, 18,0.5, 0.6, COOKIE_RECIPES.get(Lib.CookieName.CHOCOLALA)),
            new Shop(1,"NiceCookies"," 9 Rue Alberti, 06000 Nice", Place.Nice, 9, 20,0.05, 0.1, COOKIE_RECIPES.get(Lib.CookieName.CHERRY_BLOSSOM)),
            new Shop(2,"CannesCookies","39 Rue Hoche, 06400 Cannes", Place.Cannes, 9, 19,0.1, 0.2, COOKIE_RECIPES.get(Lib.CookieName.DARK_TEMPTATION))
    );

    static List<Order> FAKE_ORDERS = Arrays.asList(
            new Order(0, FAKE_REGISTERED_CUSTOMERS.get(0), new Date(), FAKE_SHOPS.get(0), Arrays.asList(new Discount((float) 0.2,"",0))),
            new Order(1, FAKE_REGISTERED_CUSTOMERS.get(1), new Date(), FAKE_SHOPS.get(1), new ArrayList<>())
    );
}
