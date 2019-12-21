package step_definitions;

import di.Injection;
import io.cucumber.java8.En;
import model.CinemaTicket;
import model.Order;
import model.Shop;
import model.consumables.Cookie;
import model.customer.Customer;
import repository.CookieRepository;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.ShopRepository;
import utils.Lib;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lydia BARAUKOVA
 */
public class CinemaStepdefs implements En {

    private CustomerRepository customerRepository = Injection.createCustomerRepository();
    private ShopRepository shopRepository = Injection.createShopRepository();
    private CookieRepository cookieRepository = Injection.createCookieRepository();
    private OrderRepository orderRepository = Injection.createOrderRepository();
    private Customer customer;
    private Order order;
    private double priceOfOrderedCookies;

    public CinemaStepdefs() {

        Given("I am a customer",
                () -> customer = customerRepository.getRandomUnregisteredCustomer());
        And("I have a cinema ticket for today",
                () -> customer.setCinemaTicket(new CinemaTicket(new Date())));

        // I can get free cookies thanks to my cinema ticket

        When("I order {int} or more cookies",
                (Integer nbOrderedCookies) -> {
                    Shop shop = shopRepository.getRandomShop();
                    Cookie chocolala = new Cookie(cookieRepository.getRecipes().get(Lib.CookieName.CHOCOLALA));
                    customer.addConsumables(chocolala, nbOrderedCookies);
                    order = shop.placeOrder(orderRepository.getNbOrders(), customer, new Date());
                    priceOfOrderedCookies = nbOrderedCookies*chocolala.getPrice();
                });
        Then("I get {int} additional cookies of the month to my {int} cookies",
                (Integer freeCookies, Integer myCookies) -> assertEquals(freeCookies, order.getCart().getNbCookies()-myCookies));
        And("They are free",
                () -> assertEquals(priceOfOrderedCookies, order.getTotalPrice()));
    }
}
