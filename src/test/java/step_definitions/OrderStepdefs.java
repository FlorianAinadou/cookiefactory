package step_definitions;

import di.Injection;
import model.Recipe;
import model.RecipeBuilder;
import model.Shop;
import model.consumables.Cookie;
import model.consumables.CookieComponent;
import model.consumables.Drink;
import model.customer.Customer;

import io.cucumber.java8.En;
import repository.CookieRepository;

import java.util.Map;

import repository.CustomerRepository;
import repository.OrderRepository;
import repository.ShopRepository;
import utils.Lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Lydia BARAUKOVA
 */
public class OrderStepdefs implements En {
    private CustomerRepository customerRepository = Injection.createCustomerRepository();
    private CookieRepository cookieRepository = Injection.createCookieRepository();
    private OrderRepository orderRepository = Injection.createOrderRepository();
    private ShopRepository shopRepository = Injection.createShopRepository();

    private Customer customer;
    private Cookie predefinedCookie;

    private RecipeBuilder recipeBuilder;
    private Recipe personalizedRecipe;
    private Cookie personalizedCookie;

    private Drink drink;

    private Shop shop;

    public OrderStepdefs() {

        // Even unregistered customers can place an order

        Given("I am an unregistered customer",
                () -> customer = customerRepository.getRandomUnregisteredCustomer());

        // I can order predefined cookies

        When("I add {int} predefined cookies named {string} to my cart",
                (Integer quantity, String cookieName) -> {
                    predefinedCookie = new Cookie(cookieRepository.getRecipes().get(cookieName));
                    customer.addConsumables(predefinedCookie, quantity);
                });
        Then("The cookie named {string} appears in my cart",
                (String cookieName) -> assertTrue(customer.getCart().getItems().containsKey(predefinedCookie)));
        And("The quantity of this predefined cookie is {int}",
                (Integer quantity) -> assertEquals(quantity, customer.getCart().getItems().get(predefinedCookie)));

        // I can't order something that is impossible to make

        When("I try to create a personalized recipe with too few ingredients",
                () -> {
                    recipeBuilder = new RecipeBuilder();
                    recipeBuilder.addTopping(cookieRepository.getToppings().get(Lib.Topping.CHERRY_SYRUP));
                    personalizedRecipe = recipeBuilder.buildRecipe();
                });
        Then("The recipe is not created",
                () -> assertNull(personalizedRecipe));

        When("I try to add more than {int} toppings",
                (Integer limit) -> {
                    recipeBuilder = new RecipeBuilder();
                    Map<String, CookieComponent> toppings = cookieRepository.getToppings();
                    int i = 0;
                    for (Map.Entry<String, CookieComponent> mapEntry : toppings.entrySet()) {
                        if (i >= limit + 1) break;
                        recipeBuilder.addTopping(mapEntry.getValue());
                        i++;
                    }
                });
        Then("The toppings that surpass the limit of {int} are not added",
                (Integer limit) -> assertEquals(limit, recipeBuilder.getToppings().size()));

        // Personalized cookies should have all the mandatory ingredients

        When("I try to create a personalized recipe named {string} with enough ingredients",
                (String recipeName) -> {
                    recipeBuilder = new RecipeBuilder();
                    recipeBuilder.setName(recipeName);
                    recipeBuilder.addDough(cookieRepository.getDough().get(Lib.Dough.OATMEAL));
                    recipeBuilder.addCooking(cookieRepository.getCooking().get(Lib.Cooking.CHEWY));
                    recipeBuilder.addMix(cookieRepository.getMix().get(Lib.Mix.MIXED));
                    recipeBuilder.addFlavour(cookieRepository.getFlavour().get(Lib.Flavour.CHILI));
                    recipeBuilder.addTopping(cookieRepository.getToppings().get(Lib.Topping.CHERRY_SYRUP));
                    personalizedRecipe = recipeBuilder.buildRecipe();
                    personalizedCookie = new Cookie(personalizedRecipe);
                });
        Then("The recipe named {string} is created",
                (String recipeName) -> assertEquals(recipeName, personalizedRecipe.getName()));

        // I can order personalized cookies

        When("I add {int} personalized cookies to my cart",
                (Integer quantity) -> {
                    recipeBuilder = new RecipeBuilder();
                    recipeBuilder.addDough(cookieRepository.getDough().get(Lib.Dough.OATMEAL));
                    recipeBuilder.addCooking(cookieRepository.getCooking().get(Lib.Cooking.CHEWY));
                    recipeBuilder.addMix(cookieRepository.getMix().get(Lib.Mix.MIXED));
                    recipeBuilder.addFlavour(cookieRepository.getFlavour().get(Lib.Flavour.CHILI));
                    recipeBuilder.addTopping(cookieRepository.getToppings().get(Lib.Topping.CHERRY_SYRUP));
                    personalizedRecipe = recipeBuilder.buildRecipe();
                    personalizedCookie = new Cookie(personalizedRecipe);
                    customer.addConsumables(personalizedCookie, quantity);
                });
        Then("This personalized cookie is added to my cart",
                () -> assertTrue(customer.getCart().getItems().containsKey(personalizedCookie)));
        And("The quantity of this personalized cookie is {int}",
                (Integer quantity) -> assertEquals(quantity, customer.getCart().getItems().get(personalizedCookie)));

        // I can place an order with both predefined and personalized cookies
        // I know if the order has been paid

        /*When("I place an order",
                () -> {
                    shop.pla
                });
        Then("My cart is emptied");
        And("A new order is created");
        And("It has not yet been paid");*/



  //Je peux payer ma commande par carte bancaire

  //Je peux passer une commande avec des cookies classiques et personnalisés

  //Je peux calculer un prix TTC à partir des ingrédients, des discounts et des taxes.

  //Je dois payer un surcoût en cas de commande de cookies personnalisés

  //Je peux recevoir des packs de cookies selon le nombre de cookies commandés

  //Je peux associer des boissons à des packs de cookies
    }
}
