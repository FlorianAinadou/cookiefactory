package step_definitions;

import di.Injection;
import io.cucumber.java8.En;

import model.Shop;
import repository.ShopRepository;

/**
 * @author Lydia BARAUKOVA
 */
public class ShopForOwnerStepdefs implements En {

    private ShopRepository shopRepository = Injection.createShopRepository();
    private Shop shop = shopRepository.getRandomShop();

    public ShopForOwnerStepdefs() {

        // I can change the opening hours of my shop

        // I can set the recipe of the month in my shop
    }
}
