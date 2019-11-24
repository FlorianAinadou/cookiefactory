package api;


import model.Discount;
import model.Order;
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

    int getOrderNum();

    void generateRandomUser();

    void deleteUser(Customer username);

    void addUser(Customer username);

    void deleteOrder(Order orderNum);

    void addOrder(Order orderNum);

    Map<String, Recipe> getCookieRecipes();

    void addDiscount(Customer customer, Discount discount);

    List<Discount> getDiscounts(Customer customer);

    float applyDiscount(Customer customer, Discount discount);
}
