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
    private static CustomerRepository customerRepository;
    private static OrderRepository orderRepository;
    private static CookieRepository cookieRepository;
    private static DiscountRepository discountRepository;
    private static ShopRepository shopRepository;

    private static void initRepositories() {
        if (cookieRepository == null) cookieRepository = Injection.createCookieRepository();
        if (shopRepository == null) shopRepository = Injection.createShopRepository();
        if (customerRepository == null) customerRepository = Injection.createCustomerRepository();
        if (orderRepository == null) orderRepository = Injection.createOrderRepository();
        if (discountRepository == null) discountRepository = Injection.createDiscountRepository();
    }

    public static void main(String[] args) {
        initRepositories();

        Map<String, Recipe> recipes = cookieRepository.getCookieRecipes();

        Customer customer = customerRepository.getRandomRegisteredCustomer();
        Shop shop = shopRepository.getRandomShop();

        customer.addConsumables(new Cookie(recipes.get(Lib.CookieName.CHOCOLALA)),4);
        customer.addConsumables(new Cookie(recipes.get(Lib.CookieName.DARK_TEMPTATION)),6);
        customer.addConsumables(new Drink(0.5f, "Sprite"),1);
        customer.showCart();
        Order order = new Order(orderRepository.getOrderNum(), customer, new Date(), shop);
        orderRepository.addOrder(order, discountRepository.getDiscounts(customer).get(0));
        orderRepository.payOrder(order, customer);
    }
}
