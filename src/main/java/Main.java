

import cookie.recipes.Chocolala;
import di.Injection;
import order.Order;
import order.OrderManager;
import order.Place;
import customer.*;
import repository.OrderRepository;
import repository.UserRepository;

import java.util.Date;
import java.util.UUID;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Main {

    private static UserRepository userRepository;
    private static OrderRepository orderRepository;

    // ---

    public static UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    public static OrderRepository getOrderRepository() {
        if (orderRepository == null) orderRepository = Injection.createOrderRepository();
        return orderRepository;
    }

    public static void main(String[] args) {
      /*
      OrderManager om = new OrderManager();
        Customer Paul = new UnregisteredCustomer("Paul", "Dupont", "0612345678", "paul@gmail.com");
        Paul.addCookies(new Chocolala(), 1);
        Paul.showCart();
        Paul.placeOrder(om, new Date(), Place.Antibes);*/

        // Je vous propose plutôt un main comme ça (Virgile)
        orderRepository = getOrderRepository();
        userRepository = getUserRepository();

        Customer Paul = Customer.random();
        userRepository.addUser(Paul);

        Paul.addCookies(new Chocolala(), 1);
        Paul.showCart();
        orderRepository.addOrder(new Order(orderRepository.getOrderNum(), Paul, new Date(), Place.Antibes));

    }
}
