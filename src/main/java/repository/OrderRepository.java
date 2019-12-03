package repository;


import api.ApiService;
import model.Discount;
import model.Order;
import model.customer.Customer;

import java.util.List;

/**
 * @author Virgile FANTAUZZI
 */

public class OrderRepository {

    private final ApiService apiService;

    public OrderRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<Order> getOrders() {
        return apiService.getOrders();
    }

    public void addOrder(Order order) {
        apiService.addOrder(order);
    }

    public void payOrder(Order order, Customer customer){
        apiService.payOrder(order, customer);
    }

    public void addOrder(Order order, Discount discount) {
        apiService.addOrder(order, discount);
    }

    public int getOrderNum() {
        return apiService.getOrderNum();
    }

    public void deleteOrder(Order order) {
        apiService.deleteOrder(order);
    }
}
