import di.Injection;
import model.Order;
import model.Recipe;
import model.RecipeBuilder;
import model.Shop;
import model.consumables.Cookie;
import model.consumables.CookieComponent;
import model.consumables.CookiesPackCreator;
import model.customer.Customer;
import model.customer.Manager;
import model.discount.EntrepriseCodePriority;
import repository.*;
import utils.Lib;
import utils.Statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Main {
    private static CookieRepository cookieRepository;
    private static CustomerRepository customerRepository;
    private static OrderRepository orderRepository;
    private static DiscountRepository discountRepository;
    private static ShopRepository shopRepository;
    private static ManagerRepository managerRepository;

    private static Shop shopStat = null; // mettre un shop si on veut avoir les stats de celui-ci

    private static void initRepositories() {
        if (cookieRepository == null) cookieRepository = Injection.createCookieRepository();
        if (shopRepository == null) shopRepository = Injection.createShopRepository();
        if (customerRepository == null) customerRepository = Injection.createCustomerRepository();
        if (orderRepository == null) orderRepository = Injection.createOrderRepository();
        if (discountRepository == null) discountRepository = Injection.createDiscountRepository();
        if (managerRepository == null) managerRepository = Injection.createManagerRepository();
    }

    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
        initRepositories();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Map<String, Recipe> recipes = cookieRepository.getRecipes();

        Map<String, CookieComponent> MIX_COOKIE = cookieRepository.getMix();
        Map<String, CookieComponent> COOKING_COOKIE = cookieRepository.getCooking();
        Map<String, CookieComponent> FLAVOUR_COOKIE = cookieRepository.getFlavour();
        Map<String, CookieComponent> DOUGH_COOKIE = cookieRepository.getDough();
        Map<String, CookieComponent> TOPPING_COOKIE = cookieRepository.getToppings();

        Manager manager = managerRepository.getManager();
        Customer customer = customerRepository.getRandomRegisteredCustomer();
        Customer customer2 = customerRepository.getRandomUnregisteredCustomer();
        Shop shop = shopRepository.getRandomShop();
        Shop shop2 = shopRepository.getRandomShop();

        Recipe cherryBlossom = recipes.get(Lib.CookieName.CHERRY_BLOSSOM);

        Recipe cod = new RecipeBuilder()
                .addCooking(COOKING_COOKIE.get(Lib.Cooking.CHEWY))
                .addDough(DOUGH_COOKIE.get(Lib.Dough.CHERRY_JAM))
                .addFlavour(FLAVOUR_COOKIE.get(Lib.Flavour.CHERRY))
                .addMix(MIX_COOKIE.get(Lib.Mix.TOPPED))
                .addTopping(TOPPING_COOKIE.get(Lib.Topping.CHERRY_SYRUP))
                .buildRecipe();

        Recipe cod2 = new RecipeBuilder()
                .addCooking(COOKING_COOKIE.get(Lib.Cooking.CRUNCHY))
                .addDough(DOUGH_COOKIE.get(Lib.Dough.PEANUT_BUTTER))
                .addFlavour(FLAVOUR_COOKIE.get(Lib.Flavour.CHOCOLATE))
                .addMix(MIX_COOKIE.get(Lib.Mix.MIXED))
                .addTopping(TOPPING_COOKIE.get(Lib.Topping.MNMS))
                .buildRecipe();


        //customer.addConsumables(new Cookie(cherryBlossom), 301  );
        customer.addConsumables(new Cookie(cod), 1);
        customer.addConsumables(new Cookie(recipes.get(Lib.CookieName.CHOCOLALA)), 10);
        //customer.addConsumables(new Cookie(recipes.get(Lib.CookieName.DARK_TEMPTATION)), 9);
        //customer.addConsumables(new Drink(0.5f, Lib.Drink.COCA_ZERO), 2);
        //customer.addConsumables(new Drink(0.5f, Lib.Drink.SPRITE), 1);
        //System.out.println(customer.getCart().getNbCookiesDirectlyInTheCart());

        CookiesPackCreator creator = new CookiesPackCreator();
        //creator.createAllPossiblePacks(customer.getCart(), cookieRepository.getPacksComposition());
        //customer.showCart();
        //creator.createPack(customer.getCart(), 30, 3);
        //System.out.println("Cookies number: " + customer.getCart().getNbCookies());
        customer.showCart();

        //shopRepository.showStock(shop);

        Order order = new Order(2, customer,new Date(System.currentTimeMillis() - 3600 * 1000), new Date(System.currentTimeMillis() - 7200 * 1000) , shop, discountRepository.getDiscounts(customer));
        //orderRepository.addOrder(order, new EntrepriseCodePriority());
        orderRepository.addOrder(order);

        orderRepository.payOrder(order, customer);
        System.out.println(order.getOrderStatus());
        orderRepository.pickUpOrder(order, shop2);

        //shopRepository.showStock(shop);


        //System.out.println("");

        //shopRepository.showStock(shop2);
/*
        customer2.addConsumables(new Cookie(cherryBlossom),40 );
        customer2.addConsumables(new Cookie(cherryBlossom),7 );

        creator.createAllPossiblePacks(customer2.getCart(), cookieRepository.getPacksComposition() );
        customer2.showCart();
        Order order2 = shop2.placeOrder(orderRepository.getNbOrders(), customer2, new Date(System.currentTimeMillis() - 3600 * 1000));
        orderRepository.addOrder(order2);
        orderRepository.payOrder(order2, customer2);
        System.out.println(order2.getOrderStatus());
        //shopRepository.showStock(shop2);
*/
        System.out.println("*****************");
        customer2.addConsumables(new Cookie(recipes.get(Lib.CookieName.DARK_TEMPTATION)),10 );
        creator.createAllPossiblePacks(customer2.getCart(), cookieRepository.getPacksComposition() );
        customer2.showCart();
        Order order3 = new Order(1, customer2, new Date(System.currentTimeMillis() - 7200 * 1000), new Date(System.currentTimeMillis() - 7200 * 1000), shop2, discountRepository.getDiscounts(customer2));
        //orderRepository.lastHourReduction(order3, new Discount(0.3f, "LAST_HOUR"));
        //customer2.showCart();

        orderRepository.addOrder(order3);
        //customer2.showCart();
        System.out.println("before pay " + order3.getOrderStatus());
        orderRepository.payOrder(order3, customer2);
        System.out.println("after : " +order3.getOrderStatus());
        orderRepository.pickUpOrder(order3, shop2);
        System.out.println("after pick up : " +order3.getOrderStatus());
        //shopRepository.showStock(shop2);

        //Manager show Stat
        manager.showStatistique();
        manager.showStatistique(shop2);

    }
}
