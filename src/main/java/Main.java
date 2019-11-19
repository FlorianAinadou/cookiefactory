

import model.Shop;
import model.cookie.Cookie;
import di.Injection;
import model.Order;
import model.Place;
import model.cookie.Recipe;
import model.customer.*;
import repository.CookieRepository;
import repository.DiscountRepository;
import repository.OrderRepository;
import repository.UserRepository;

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

    private static UserRepository userRepository;
    private static OrderRepository orderRepository;
    private static CookieRepository cookieRepository;
    private static DiscountRepository discountRepository;

    // ---

    public static UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    public static OrderRepository getOrderRepository() {
        if (orderRepository == null) orderRepository = Injection.createOrderRepository();
        return orderRepository;
    }
    public static CookieRepository getCookieRepository() {
        if (cookieRepository == null) cookieRepository = Injection.createCookieRepository();
        return cookieRepository;
    }
    public static DiscountRepository getDiscountRepository() {
        if (discountRepository == null) discountRepository = Injection.createDiscountRepository();
        return discountRepository;
    }

    public static void main(String[] args) {
      /*
      OrderManager om = new OrderManager();
        Customer Paul = new UnregisteredCustomer("Paul", "Dupont", "0612345678", "paul@gmail.com");
        Paul.addCookies(new Chocolala(), 1);
        Paul.showCart();
        Paul.placeOrder(om, new Date(), Place.Antibes);*/

        // Je vous propose plutôt un main comme ça (Virgile)
        SimpleDateFormat horaire = new SimpleDateFormat("HH:mm");
        try {
            Shop placeToBe = new Shop(" 6 Rue de la République", Place.Antibes, horaire.parse("08:00"), horaire.parse("19:00"),0.02);


        orderRepository = getOrderRepository();
        userRepository = getUserRepository();
        cookieRepository = getCookieRepository();
        discountRepository = getDiscountRepository();

        Map<String, Recipe> recipes = getCookieRepository().getCookieRecipes();

        Customer Paul = Customer.random();
        userRepository.addUser(Paul);

        Paul.addCookies(new Cookie(recipes.get("Chocolala")),4);
        Paul.addCookies(new Cookie(recipes.get("DarkTemptation")),2);
        Paul.showCart();
        orderRepository.addOrder(new Order(orderRepository.getOrderNum(), Paul, new Date(), placeToBe));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
