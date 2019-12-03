import di.Injection;
import model.Recipe;
import model.Shop;
import model.Order;
import model.consumables.Cookie;
import model.consumables.Drink;
import model.customer.Customer;
import repository.*;
import utils.Lib;

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

    private static UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    private static OrderRepository getOrderRepository() {
        if (orderRepository == null) orderRepository = Injection.createOrderRepository();
        return orderRepository;
    }
    private static CookieRepository getCookieRepository() {
        if (cookieRepository == null) cookieRepository = Injection.createCookieRepository();
        return cookieRepository;
    }
    private static DiscountRepository getDiscountRepository() {
        if (discountRepository == null) discountRepository = Injection.createDiscountRepository();
        return discountRepository;
    }

    public static void main(String[] args) {
        orderRepository = getOrderRepository();
        userRepository = getUserRepository();
        cookieRepository = getCookieRepository();
        discountRepository = getDiscountRepository();

        Map<String, Recipe> recipes = getCookieRepository().getCookieRecipes();

        Customer Paul = userRepository.getUsers().get(0);
        Shop placeToBe = Shop.random();
        userRepository.addUser(Paul);

        Paul.addConsumables(new Cookie(recipes.get(Lib.CookieName.CHOCOLALA)),4);
        Paul.addConsumables(new Cookie(recipes.get(Lib.CookieName.DARK_TEMPTATION)),6);
        Paul.addConsumables(new Drink(0.5f, "Sprite"),1);
        Paul.showCart();
        orderRepository.addOrder(new Order(orderRepository.getOrderNum(), Paul, placeToBe), discountRepository.getDiscounts(Paul).get(0));
    }
}
