

import di.Injection;
import model.Order;
import model.RecipeCookie;
import model.Shop;
import model.consumables.Cookie;
import model.consumables.Drink;
import model.customer.Customer;
import repository.CookieRepository;
import repository.DiscountRepository;
import repository.OrderRepository;
import repository.UserRepository;

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
        orderRepository = getOrderRepository();
        userRepository = getUserRepository();
        cookieRepository = getCookieRepository();
        discountRepository = getDiscountRepository();

        Map<String, RecipeCookie> recipes = getCookieRepository().getCookieRecipes();

        Customer Paul = userRepository.getUsers().get(0);
        Shop placeToBe = Shop.random();
        userRepository.addUser(Paul);


        Paul.addConsumables(new Cookie(recipes.get("Chocolala")),4);
        Paul.addConsumables(new Cookie(recipes.get("DarkTemptation")),26);

        Paul.showCart();

        orderRepository.addOrder(new Order(orderRepository.getOrderNum(), Paul, placeToBe), discountRepository.getDiscounts(Paul).get(0));

            Paul.addConsumables(new Cookie(recipes.get("Chocolala")),4);
            Paul.addConsumables(new Cookie(recipes.get("DarkTemptation")),6);
            Paul.addConsumables(new Drink(0.5f, "Sprite"),1);
            Paul.showCart();
            orderRepository.addOrder(new Order(orderRepository.getOrderNum(), Paul, placeToBe), discountRepository.getDiscounts(Paul).get(0));





    }
}
