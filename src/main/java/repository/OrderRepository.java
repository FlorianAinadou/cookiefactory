package repository;

import api.ApiService;
import model.Order;
import model.customer.Customer;
import model.discount.DiscountStrategy;

import java.util.List;

/**
 * @author Virgile FANTAUZZI
 */
public class OrderRepository {

    private final ApiService apiService;

    public OrderRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<Order> getOrders() { return apiService.getOrders(); }
    public int getOrderNum() { return apiService.getOrderNum(); }
    public void addOrder(Order order) throws CloneNotSupportedException { apiService.addOrder(order); }
    public void addOrder(Order order, DiscountStrategy discountStrategy) throws CloneNotSupportedException { apiService.addOrder(order, discountStrategy); }

    //public void addOrder(Order order, Discount discount) { apiService.addOrder(order, discount); }

    public void payOrder(Order order, Customer customer){ apiService.payOrder(order, customer); }
    public void deleteOrder(Order order) { apiService.deleteOrder(order); }
}
