package step_definitions;

import di.Injection;
import repository.CookieRepository;
import repository.ShopRepository;
import model.consumables.CookieComponent;
import utils.Lib;

import io.cucumber.java8.En;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lydia BARAUKOVA
 */
public class RecipeManagementStepdefs implements En {

    private CookieRepository cookieRepository;
    private ShopRepository shopRepository;

    public RecipeManagementStepdefs() {

        Given("I have a list of ingredients and recipes for my cookie shops",
                () -> { cookieRepository = Injection.createCookieRepository();
                        shopRepository = Injection.createShopRepository(); });

        // I can add new ingredients

        When("I add a new dough named {string} of price {float}",
                (String name, Float price) -> cookieRepository.addDough(name, new CookieComponent(Lib.ComponentType.DOUGH, name, price)));
        Then("A dough named {string} appears in my list",
                (String name) -> assertTrue(cookieRepository.getDough().containsKey(name)));

        When("I add a new flavour named {string} of price {float}",
                (String name, Float price) -> cookieRepository.addFlavour(name, new CookieComponent(Lib.ComponentType.FLAVOUR, name, price)));
        Then("A flavour named {string} appears in my list",
                (String name) -> assertTrue(cookieRepository.getFlavour().containsKey(name)));

        When("I add a new topping named {string} of price {float}",
                (String name, Float price) -> cookieRepository.addTopping(name, new CookieComponent(Lib.ComponentType.TOPPING, name, price)));
        Then("A topping named {string} appears in my list",
                (String name) -> assertTrue(cookieRepository.getToppings().containsKey(name)));

        // I can manage margins on cookies (ingredients, personalized recipes)

        When("In the shop of id {int} I change the margin for all products to {float}",
                (Integer shopId, Float margin) -> shopRepository.getShops().get(shopId).setTax(margin));
        Then("The margin for all products in the shop of id {int} becomes {float}",
                (Integer shopId, Float margin) -> assertEquals(margin.floatValue(), shopRepository.getShops().get(shopId).getTax()));

        When("In the shop of id {int} I change the margin for personalized cookies to {float}",
                (Integer shopId, Float margin) -> shopRepository.getShops().get(shopId).setCodTax(margin));
        Then("The margin for personalized cookies in the shop of id {int} becomes {float}",
                (Integer shopId, Float margin) -> assertEquals(margin.floatValue(), shopRepository.getShops().get(shopId).getCodTax()));

        When("I set the price of the dough named {string} to {float}",
                (String name, Float price) -> cookieRepository.getDough().get(name).setPrice(price));
        Then("The price of the dough named {string} becomes {float}",
                (String name, Float price) -> assertEquals(price.floatValue(), cookieRepository.getDough().get(name).getPrice()));

        When("I set the price of the flavour named {string} to {float}",
                (String name, Float price) -> cookieRepository.getFlavour().get(name).setPrice(price));
        Then("The price of the flavour named {string} becomes {float}",
                (String name, Float price) -> assertEquals(price.floatValue(), cookieRepository.getFlavour().get(name).getPrice()));

        When("I set the price of the topping named {string} to {float}",
                (String name, Float price) -> cookieRepository.getToppings().get(name).setPrice(price));
        Then("The price of the topping named {string} becomes {float}",
                (String name, Float price) -> assertEquals(price.floatValue(), cookieRepository.getToppings().get(name).getPrice()));
    }
}
