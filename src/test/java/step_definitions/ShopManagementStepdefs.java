package step_definitions;

import di.Injection;
import repository.CookieRepository;
import repository.ShopRepository;
import model.Shop;

import io.cucumber.java8.En;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lydia BARAUKOVA
 */
public class ShopManagementStepdefs implements En {

    private ShopRepository shopRepository = Injection.createShopRepository();
    private CookieRepository cookieRepository = Injection.createCookieRepository();
    private Shop shop;

    public ShopManagementStepdefs() {

        Given("I have a shop",
                () -> shop = shopRepository.getShops().get(1));

        // I can change the working hours of my shop

        When("I set the opening hour of my shop to {int} and the closing hour of my shop to {int}",
                (Integer opening, Integer closing) -> shop.setWorkingHours(opening, closing));
        Then("The opening hour of my shop becomes {int}",
                (Integer opening) -> assertEquals(opening, shop.getOpeningHour()));
        And("The closing hour of my shop becomes {int}",
                (Integer closing) -> assertEquals(closing, shop.getClosingHour()));

        // I can set the recipe of the month in my shop

        When("I set {string} to be the recipe of the month in my shop",
                (String recipe) -> shop.setRecipeOfTheMonth(cookieRepository.getRecipes().get(recipe)));
        Then("The recipe of the month in my shop becomes {string}",
                (String recipe) -> assertEquals(recipe, shop.getRecipeOfTheMonth().getName()));
    }
}
