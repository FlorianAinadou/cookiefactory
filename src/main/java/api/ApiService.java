package api;


import customer.Customer;
import order.Order;

import java.util.List;

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
}
