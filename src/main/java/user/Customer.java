package user;

import order.Cart;
import order.Order;
import order.Place;

import java.util.Date;

/**
 * @author Aldric DUCREUX
 */
public class Customer extends User {

    public Customer(int id, String firstname, String name, int age, String mail, String adress, int countCookie) {
        super(id, firstname, name, age, mail, adress, countCookie);
    }

    public Order makeOrder(Cart cart, Customer customer, int orderNumber, Date date, Place place){

        return new Order(orderNumber, cart, customer, date, place);
    }
}
