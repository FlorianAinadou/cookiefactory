package api;


import model.discount.Discount;
import model.Order;
import model.Recipe;
import model.Shop;
import model.consumables.CookieComponent;
import model.customer.Customer;

import java.util.List;
import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 */
public interface ApiService {

    List<Customer> getCustomers();
    Customer getRandomRegisteredCustomer();
    Customer getRandomUnregisteredCustomer();
    void addCustomer(Customer username);
    void deleteCustomer(Customer username);

    List<Shop> getShops();
    Shop getRandomShop();
    void addShop(Shop shop);
    void deleteShop(Shop shop);

    List<Order> getOrders();
    int getOrderNum();
    void addOrder(Order orderNum);
    void deleteOrder(Order orderNum);
    void addOrder(Order order, Discount discount);
    void payOrder(Order order, Customer customer);

    Map<String, Recipe> getCookieRecipes();
    void addCookieRecipe(String name, Recipe recipe);
    void changeRecipesMargin(String recipeName, double value);

    Map<String, CookieComponent> getCookieDough();
    Map<String, CookieComponent> getCookieTopping();
    Map<String, CookieComponent> getCookieMix();
    Map<String, CookieComponent> getCookieCooking();
    Map<String, CookieComponent> getCookieFlavour();

    List<Discount> getDiscounts(Customer customer);
    void addDiscount(Customer customer, Discount discount);
    double applyDiscount(Customer customer, Shop shop, Discount discount);
    float askForADiscountApplying(Customer customer, Discount discount);
}
