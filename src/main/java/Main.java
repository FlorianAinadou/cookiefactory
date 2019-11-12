

import cookie.recipes.Chocolala;
import order.OrderCreator;
import order.ReservationsPlace;
import user.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        OrderCreator orderCreator= new OrderCreator();
        System.out.println("Hello World!");
        Customer Paul= new Customer(1, null, null, -99, null, null, 0);
        Paul.createNewBasket();
        Paul.getBasket().addCookies(new Chocolala(), 1);
        Paul.showMyBasket();
        orderCreator.createNewOrder(Paul.makeOrder(Paul.getBasket(), Paul, new Date(), ReservationsPlace.Antibes));
    }
}
