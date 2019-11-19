package api;


import model.Discount;
import model.cookie.Cookie;
import model.customer.Customer;
import model.customer.RegisteredCustomer;
import model.Order;

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

    Map<String, Cookie> getCookieRecipes();

    void addDiscount(RegisteredCustomer customer, Discount discount);

    List<Discount> getDiscounts(RegisteredCustomer customer);

    float applyDiscount(RegisteredCustomer customer, Discount discount);
}
