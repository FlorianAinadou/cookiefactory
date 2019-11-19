package model;

import com.sun.istack.internal.Nullable;
import model.customer.Customer;

import java.util.Date;
import java.util.Objects;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
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
        customer.emptyCart(); // and empty the model.customer's cart
        this.date = new Date();
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public Place getPlace() {
        return place;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Order)) return false;
        return (((Order) obj).getId() == (this.getId()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate());
    }
}
