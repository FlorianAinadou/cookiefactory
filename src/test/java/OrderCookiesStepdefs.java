import cookie.Cookie;
import cookie.parameters.CookieName;
import cookiefactory.CookieFactory;
import order.Order;
import user.Customer;
import user.User;


import io.cucumber.java8.En;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Lydia BARAUKOVA
 */
public class OrderCookiesStepdefs implements En {

    private CookieFactory factory = new CookieFactory();
    private Cookie cookie;
    private User customer;
    private Order order;

    public OrderCookiesStepdefs() {
        Given("an client of name {string}",
                (String customerName) ->
                    customer = new Customer(1,customerName,"Black",20,
                            "mynameisjeff@gmail.com","89 Avenue de Nice 06200 Nice France",
                            0)
        );

        And("a cookie named {string}", (CookieName name) -> cookie = factory.createCookie(name));

        When("{string} adds {int} {string} to his cart",);

        Then("A new item named {string} appears in his cart",);

        And("The quantity of this item is {int}",);

        And("The total sum to pay is updated",);
    }
}
