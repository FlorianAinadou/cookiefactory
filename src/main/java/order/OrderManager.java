package order;

import customer.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */


/// Classe dépréciée, je vous propose plutôt d'utiliser le {@Link OrderRepository}
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
