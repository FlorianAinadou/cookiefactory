package api;


import model.Discount;
import model.Order;
import model.Recipe;
import model.Shop;
import model.consumables.CookieComponent;
import model.customer.Customer;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 */

public interface ApiService {
    List<Customer> getUsers();

    List<Order> getOrders();

    List<Shop> getShops();

    int getOrderNum();

    void generateRandomUser();

    void deleteUser(Customer username);

    void addUser(Customer username);

    void deleteOrder(Order orderNum);

    void addOrder(Order orderNum);

    Map<String, Recipe> getCookieRecipes();

    Map<String, CookieComponent> getCookieDough();

    Map<String, CookieComponent> getCookieTopping();

    Map<String, CookieComponent> getCookieMix();

    Map<String, CookieComponent> getCookieCooking();

    Map<String, CookieComponent> getCookieFlavour();

    void addOrder(Order order, Discount discount);

    void payOrder(Order order, Customer customer);

    void addShop(Shop shop);

    void deleteShop(Shop shop);

    void changeMarginRecipes(String name, double value);

    void changeHorairesShop(Shop shop, Date open, Date close);

    void addDiscount(Customer customer, Discount discount);

    List<Discount> getDiscounts(Customer customer);

    double applyDiscount(Customer customer, Shop shop, Discount discount);

    float askForADiscountApplying(Customer customer, Discount discount);
}
