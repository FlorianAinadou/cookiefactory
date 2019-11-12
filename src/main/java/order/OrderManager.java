package order;

import customer.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @athor Florian AINADOU
 * @author Lydia BARAUKOVA
 */
public class OrderManager {
    private List<Order> orderList;
    private int orderId;

    public OrderManager() {
        orderList = new ArrayList<>();
        orderId = 0;
    }

    public int placeOrder(Customer customer, Date date, Place place) {
        orderId++;
        Order order = new Order(orderId, customer, date, place);
        orderList.add(order);
        System.out.println("The order №" + orderId + " has been placed!");
        return orderId;
    }

    public List<Order> getOrderList() { return orderList; }
}
