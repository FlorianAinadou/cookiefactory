package order;

import customer.Customer;

import java.util.Date;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 */
public class Order {
    private final int id;  // just a  random number given to every order
    private final Cart cart;
    private final Customer customer;
    private final Date date; // the order date and hour
    private final Place place; // the place where the order will be collected

    public Order(int id, Customer customer, Date date, Place place) {
        this.id = id;
        this.customer = customer;
        this.cart = customer.getCart(); // we save the cart in the order
        customer.emptyCart(); // and empty the customer's cart
        this.date = new Date();
        this.place = place;
    }

    public int getId() { return id; }
    public Cart getCart() { return cart; }
    public Customer getCustomer() { return customer; }
    public Date getDate() { return date; }
    public Place getPlace() { return place; }
}
