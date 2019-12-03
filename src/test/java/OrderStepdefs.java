package java;

import model.customer.Customer;
import model.customer.UnregisteredCustomer;
import model.cookie.Cookie;
import model.cookie.parameters.CookieName;
import cookiefactory.CookieFactory;

import io.cucumber.java8.En;
import model.Place;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lydia BARAUKOVA
 */
public class OrderStepdefs implements En {
    private CookieFactory cookieFactory = new CookieFactory();
    //private OrderManager orderManager = new OrderManager();
    private Customer customer;
    private Cookie cookie;
    private int orderId;



    public OrderStepdefs() {
        Given("an unregistered model.customer of first name {string}, last name {string}, tel {string}" +
                        "and email {string} wants to place an order in the CoD shop",
                (String firstName, String lastName, String tel, String email) ->
                    customer = new UnregisteredCustomer(firstName, lastName, tel, email)
        );
        And("he wants to order cookies named {string}",
                (CookieName name) -> cookie = cookieFactory.createCookie(name));



        When("the model.customer adds {int} cookies in his cart",
                (Integer quantity) -> customer.addCookies(cookie, quantity));
        Then("A new item named like the wanted model.cookie appears in his cart",
                () -> assertTrue(customer.getCart().getItems().containsKey(cookie)));
        And("The quantity of this item is {int}",
                (Integer quantity) -> assertEquals(customer.getCart().getItems().get(cookie), quantity));
        And("The total sum to pay is updated",
                () -> assertNotEquals(0, customer.getCart().getTotalPrice()));



       /* When("the model.customer places his order to be delivered on a specific date and time, at a certain place",
                (Date date, Place place) -> orderId = customer.placeOrder(orderManager, date, place));
        Then("the order is added to the shop's order list",
                () -> assertEquals(orderId, orderManager.getOrderList().get(0).getId()));
        And("the cart of the model.customer is now empty",
                () -> assertTrue(customer.getCart().getItems().isEmpty()));*/
    }
}
