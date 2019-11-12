package order;

import user.Customer;

import java.util.Date;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 */
public class Order {
    private final int id;  // tust a  random number given to every order
    private final Cart cart;
    private final Customer customer;
    private final Date date; // the order date and hour
    private final Place place; // the place where the order will be collected

    public Order(int id, Cart cart, Customer customer, Date date, Place place){
        this.id = id;
        this.cart = cart;
        this.customer= customer;
        this.date = date;
        this.place = place;
    }

    public int getId() { return id; }
    public Cart getCart() { return cart; }
    public Customer getCustomer() { return customer; }
    public Date getDate() { return date; }
    public Place getPlace() { return place; }
}
