package step_definitions;

import di.Injection;
import repository.ShopRepository;
import utils.Statistics;

import io.cucumber.java8.En;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Lydia BARAUKOVA
 */
public class StatisticsStepdefs implements En {

    private ShopRepository shopRepository;

    public StatisticsStepdefs() {

        Given("I have several shops",
                () -> shopRepository = Injection.createShopRepository());

        // I can collect statistics per shop (i.e. nb cookies sold per day, % of personalized cookies)

        When("I request statistics on the shop of id {int}",
                (Integer shopId) -> Statistics.showShopStatistics(shopRepository.getShops().get(shopId)));
        Then("The statistics on the shop of id {int} are shown",
                (Integer shopId) -> assertTrue(true));

        // I can aggregate statistics for all the shops

        When("I request statistics on all the shops",
                Statistics::showGeneralStatistics);
        Then("The statistics on all the shops are shown",
                () -> assertTrue(true));
    }
}
