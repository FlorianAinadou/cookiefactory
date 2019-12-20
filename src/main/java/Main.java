import di.Injection;
import model.Order;
import model.Recipe;
import model.Shop;
import model.builders.RecipeBuilder;
import model.consumables.Cookie;
import model.consumables.CookieComponent;
import model.consumables.CookiesPackCreator;
import model.consumables.Drink;
import model.customer.Customer;
import repository.*;
import utils.Lib;
import utils.Statistics;

import java.util.ArrayList;
import java.util.Collections;
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

    private static Shop shopStat = null; // mettre un shop si on veut avoir les stats de celui-ci

    private static void initRepositories() {
        if (cookieRepository == null) cookieRepository = Injection.createCookieRepository();
        if (shopRepository == null) shopRepository = Injection.createShopRepository();
        if (customerRepository == null) customerRepository = Injection.createCustomerRepository();
        if (orderRepository == null) orderRepository = Injection.createOrderRepository();
        if (discountRepository == null) discountRepository = Injection.createDiscountRepository();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        initRepositories();

        Map<String, Recipe> recipes = cookieRepository.getRecipes();

        Map<String, CookieComponent> MIX_COOKIE = cookieRepository.getMix();
        Map<String, CookieComponent> COOKING_COOKIE = cookieRepository.getCooking();
        Map<String, CookieComponent> FLAVOUR_COOKIE = cookieRepository.getFlavour();
        Map<String, CookieComponent> DOUGH_COOKIE = cookieRepository.getDough();
        Map<String, CookieComponent> TOPPING_COOKIE = cookieRepository.getTopping();

        Customer customer = customerRepository.getRandomRegisteredCustomer();
        Customer customer2 = customerRepository.getRandomUnregisteredCustomer();
        Shop shop = shopRepository.getRandomShop();
        Shop shop2 = shopRepository.getRandomShop();

        Recipe cherryBlossom = recipes.get(Lib.CookieName.CHERRY_BLOSSOM);

        Recipe cod = new RecipeBuilder(shop.getCodTax())
                .cooking(COOKING_COOKIE.get(Lib.Cooking.CHEWY))
                .dough(DOUGH_COOKIE.get(Lib.Dough.CHERRY_JAM))
                .flavour(FLAVOUR_COOKIE.get(Lib.Flavour.CHERRY))
                .mix(MIX_COOKIE.get(Lib.Mix.TOPPED))
                .toppings(new ArrayList<>(Collections.singletonList(TOPPING_COOKIE.get(Lib.Topping.CHERRY_SYRUP))))
                .marginPrice(2.00)
                .buildRecipe();


        customer.addConsumables(new Cookie(cherryBlossom), 21);
        customer.addConsumables(new Cookie(cod), 1);
        customer.addConsumables(new Cookie(recipes.get(Lib.CookieName.CHOCOLALA)), 10);
        customer2.addConsumables(new Cookie(recipes.get(Lib.CookieName.DARK_TEMPTATION)), 16);
        customer2.addConsumables(new Drink(0.5f, Lib.Drink.COCA_ZERO), 1);
        customer.addConsumables(new Drink(0.5f, Lib.Drink.SPRITE), 1);


        System.out.println("Cookies number: " + customer.getCart().getNbCookies());
        CookiesPackCreator creator = new CookiesPackCreator();
        creator.createAllPossiblePacks(customer.getCart(), cookieRepository.getPacksComposition());
        customer.showCart();
        //creator.createPack(customer.getCart(), 30, 3);
        //System.out.println("Cookies number: " + customer.getCart().getNbCookies());
        //customer.showCart();

        shopRepository.showStock(shop);

        Order order = new Order(orderRepository.getOrderNum(), customer, new Date(), shop, discountRepository.getDiscounts(customer));
        //orderRepository.addOrder(order, new EntrepriseCodePriority());
        orderRepository.addOrder(order);

        orderRepository.payOrder(order, customer);
        System.out.println(order.getOrderStatus());

        shopRepository.showStock(shop);

        System.out.println("");

        shopRepository.showStock(shop2);


        Order order2 = new Order(orderRepository.getOrderNum(), customer2, new Date(), shop2, discountRepository.getDiscounts(customer2));
        orderRepository.addOrder(order2);
        orderRepository.payOrder(order2, customer2);
        System.out.println(order2.getOrderStatus());
        shopRepository.showStock(shop2);

        //stat


        Statistics.showGeneralStatistics();
        Statistics.showShopStatistics(shop2);
    }
}
