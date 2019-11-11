package user;

import order.Basket;
import order.Order;
import order.ReservationsPlace;

import java.util.Date;

public class Customer extends User {

    public Customer(int id, String firstname, String name, int age, String mail, String adress, int countCookie) {
        super(id, firstname, name, age, mail, adress, countCookie);
    }

    //As his name says it
    public Order makeOrder(Basket basket, Customer customer, int orderNumber, Date date, ReservationsPlace reservationsPlace){

        return new Order(basket, customer, orderNumber, date, reservationsPlace);
    }
}
