package step_definitions;

import di.Injection;
import model.Recipe;
import model.consumables.Cookie;
import model.customer.Customer;
import model.customer.UnregisteredCustomer;

import io.cucumber.java8.En;
import repository.CookieRepository;

import java.util.Map;
import model.consumables.Cookie;

import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lydia BARAUKOVA
 */
public class OrderStepdefs implements En {
    private Customer customer;
    private Cookie cookie;

    private CookieRepository COOKIE_REPOSITORY = Injection.createCookieRepository();
    private Map<String, Recipe> COOKIE_RECIPES = COOKIE_REPOSITORY.getCookieRecipes();

    public OrderStepdefs() {
        Given("a client named {string}",
                (String firstName, String lastName, String tel, String email) ->
                    customer = new UnregisteredCustomer(firstName, lastName, tel, email, 2.00));
        And("a cookie named {string}",
                (String cookieName) -> cookie = new Cookie(COOKIE_RECIPES.get(cookieName)));





        When("{string} adds {int} {string} to his cart",
                (Integer quantity) -> customer.addConsumables(cookie, quantity));
        Then("A new item named {string} appears in his cart",

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
