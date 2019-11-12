import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Lydia BARAUKOVA
 */
public class OrderCookiesStepdefs implements En {

    public OrderCookiesStepdefs() {
        Given("a client named {string}", );

        And("a cookie named {string}", );

        When("{string} adds {int} {string} to his cart",);

        Then("A new item named {string} appears in his cart",);

        And("The quantity of this item is {int}",);

        And("The total sum to pay is updated",);
    }
}
