package api;

import model.Discount;
import model.Place;
import model.Shop;
import model.cookie.Recipe;
import model.cookie.ingredients.Dough;
import model.cookie.ingredients.Flavour;
import model.cookie.ingredients.Topping;
import model.cookie.parameters.CookieName;
import model.cookie.parameters.Cooking;
import model.cookie.parameters.Mix;
import model.customer.Customer;
import model.customer.RegisteredCustomer;
import model.customer.UnregisteredCustomer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
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

    static Map<Customer, ArrayList<Discount>> generateDiscounts() {
        return new HashMap<Customer, ArrayList<Discount>>(DISCOUNTS);
    }
    static List<Shop> generateShops() { return new ArrayList<>(FAKE_SHOPS);}

    static Map<String, Discount> getShopDiscounts(){
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


    private static Map<String, Recipe> RECIPES_COOKIE = new HashMap<String, Recipe>() {{
        put("CherryBlossom", new Recipe(CookieName.cherryBlossom.toString(), Dough.cherryJam, Cooking.chewy, Flavour.cherry, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.cherrySyrup))));
        put("Chocolala", new Recipe(CookieName.chocolala.toString(), Dough.chocolate, Cooking.chewy, Flavour.chocolate, Mix.topped, new ArrayList<>(Collections.singletonList(Topping.milkChocolate))));
        put("DarkTemptation", new Recipe(CookieName.darkTemptation.toString(), Dough.chocolate, Cooking.crunchy, Flavour.chocolate, Mix.mixed, new ArrayList<>(Collections.singletonList(Topping.darkChocolate))));
    }};

    private static Map<RegisteredCustomer, ArrayList<Discount>> DISCOUNTS = new HashMap<RegisteredCustomer, ArrayList<Discount>>() {{
        put((RegisteredCustomer)FAKE_USERS.get(0), new ArrayList<>(Collections.singletonList(new Discount(0.10f, "PROMO10"))));
    }};

    private static HashMap<String , Discount> SHOP_DISCOUNTS = new HashMap<String, Discount>(){{
        put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
        //put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));
        //put("LOYALTY_PROGRAM",new Discount(0.1f, "LOYALTY_PROGRAM"));


    }};

}
