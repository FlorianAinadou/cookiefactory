

import cookie.recipes.Chocolala;
import order.OrderManager;
import order.Place;
import customer.*;

import java.util.Date;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 */
public class Main {
    public static void main(String[] args) {
        OrderManager om = new OrderManager();
        Customer Paul= new UnregisteredCustomer("Paul", "Dupont", "0612345678", "paul@gmail.com");
        Paul.addCookies(new Chocolala(), 1);
        Paul.showCart();
        Paul.placeOrder(om, new Date(), Place.Antibes);
    }
}
