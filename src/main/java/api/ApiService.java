package api;


import model.Discount;
import model.Order;
import model.RecipeCookie;
import model.cookie.CookieComposant;
import model.Shop;
import model.cookie.Recipe;
import model.customer.Customer;

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

    Map<String, RecipeCookie> getCookieRecipes();

    Map<String, CookieComposant> getCookieDough();

    Map<String, CookieComposant> getCookieTopping();

    Map<String, CookieComposant> getCookieMix();

    Map<String, CookieComposant> getCookieCooking();

    Map<String, CookieComposant> getCookieFlavour();

    void addOrder(Order order, Discount discount);

    void addShop(Shop shop);

    void deleteShop(Shop shop);


    void addDiscount(Customer customer, Discount discount);

    List<Discount> getDiscounts(Customer customer);

    double applyDiscount(Customer customer, Discount discount);

    float askForADiscountApplying(Customer customer, Discount discount);
}
