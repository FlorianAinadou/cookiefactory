import di.Injection;
import model.Order;
import model.Recipe;
import model.Shop;
import model.builders.RecipeBuilder;
import model.consumables.Cookie;
import model.consumables.CookieComponent;
import model.consumables.Drink;
import model.customer.Customer;
import model.discount.EntrepriseCodePriority;
import repository.CookieRepository;
import repository.DiscountRepository;
import repository.OrderRepository;
import repository.UserRepository;
import utils.Lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Main {
    private static UserRepository userRepository;
    private static OrderRepository orderRepository;
    private static CookieRepository cookieRepository;
    private static DiscountRepository discountRepository;

    private static UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    private static OrderRepository getOrderRepository() {
        if (orderRepository == null) orderRepository = Injection.createOrderRepository();
        return orderRepository;
    }

    private static CookieRepository getCookieRepository() {
        if (cookieRepository == null) cookieRepository = Injection.createCookieRepository();
        return cookieRepository;
    }

    private static DiscountRepository getDiscountRepository() {
        if (discountRepository == null) discountRepository = Injection.createDiscountRepository();
        return discountRepository;
    }

    public static void main(String[] args) {

        orderRepository = getOrderRepository();
        userRepository = getUserRepository();
        cookieRepository = getCookieRepository();
        discountRepository = getDiscountRepository();

        Map<String, CookieComponent> MIX_COOKIE = cookieRepository.getCookieMix();
        Map<String, CookieComponent> COOKING_COOKIE = cookieRepository.getCookieCooking();
        Map<String, CookieComponent> FLAVOUR_COOKIE = cookieRepository.getCookieFlavour();
        Map<String, CookieComponent> DOUGH_COOKIE = cookieRepository.getCookieDough();
        Map<String, CookieComponent> TOPPING_COOKIE = cookieRepository.getCookieTopping();

        Map<String, Recipe> recipes = getCookieRepository().getCookieRecipes();

        Customer Paul = userRepository.getUsers().get(0);
        Shop placeToBe = Shop.random();
        userRepository.addUser(Paul);

        Recipe cherry_blossom = recipes.get(Lib.CookieName.CHERRY_BLOSSOM);

        Recipe codPaul = new RecipeBuilder(placeToBe.getTaxeCod())
                .cooking(COOKING_COOKIE.get(Lib.Cooking.CHEWY))
                .dough(DOUGH_COOKIE.get(Lib.Dough.CHERRY_JAM))
                .flavour(FLAVOUR_COOKIE.get(Lib.Flavour.CHERRY))
                .mix(MIX_COOKIE.get(Lib.Mix.TOPPED))
                .toppings(new ArrayList<>(Collections.singletonList(TOPPING_COOKIE.get(Lib.Topping.CHERRY_SYRUP))))
                .marginPrice(2.00)
                .buildRecipe();


        Paul.addConsumables(new Cookie(cherry_blossom), 1);
        Paul.addConsumables(new Cookie(codPaul), 1);
        Paul.addConsumables(new Cookie(recipes.get(Lib.CookieName.CHOCOLALA)), 4);
        Paul.addConsumables(new Cookie(recipes.get(Lib.CookieName.DARK_TEMPTATION)), 6);
        Paul.addConsumables(new Drink(0.5f, "Sprite"), 1);
        Paul.showCart();

        Order order = new Order(orderRepository.getOrderNum(), Paul, new Date(), placeToBe, getDiscountRepository().getDiscounts(Paul));
        orderRepository.addOrder(order, new EntrepriseCodePriority());

        orderRepository.payOrder(order, Paul);
        System.out.println(order.getOrderStatu());
    }
}
