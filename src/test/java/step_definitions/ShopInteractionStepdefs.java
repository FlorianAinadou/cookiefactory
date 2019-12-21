package step_definitions;

import di.Injection;
import io.cucumber.java8.En;
import model.Order;
import model.RecipeBuilder;
import model.Shop;
import model.consumables.Cookie;
import model.customer.Customer;
import repository.CookieRepository;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.ShopRepository;
import utils.Lib;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Lydia BARAUKOVA
 */
public class ShopInteractionStepdefs implements En {

    private CustomerRepository customerRepository = Injection.createCustomerRepository();
    private CookieRepository cookieRepository = Injection.createCookieRepository();
    private ShopRepository shopRepository = Injection.createShopRepository();
    private OrderRepository orderRepository = Injection.createOrderRepository();

    private Customer customer;
    private Shop shop = shopRepository.getRandomShop();
    private Order order;

    public ShopInteractionStepdefs() {

        Given("I'm a customer",
                () -> customer = customerRepository.getRandomUnregisteredCustomer());

        When("I collect my order",
                () -> {
                    Cookie predefinedCookie = new Cookie(cookieRepository.getRecipes().get(Lib.CookieName.CHOCOLALA));
                    customer.addConsumables(predefinedCookie, 20);
                    order = shop.placeOrder(orderRepository.getNbOrders(),customer,new Date());
                    orderRepository.addOrder(order);
                    orderRepository.payOrder(order,customer);
                    orderRepository.pickUpOrder(order,shop);
                });
        Then("My order is collected",
                () -> assertFalse(shop.getWaitOrder().contains(order)));

        //Je ne peux pas commander en dehors des horaires d'ouverture

        //Je ne peux pas retirer ma commande avant l’heure spécifiée lors de la commande

        //Je peux retirer ma commande

    }
}
