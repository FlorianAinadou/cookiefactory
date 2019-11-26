package model;


<<<<<<< HEAD

import com.sun.istack.internal.Nullable;
=======
>>>>>>> ffc557fff004a3b46bdf93ffa64cce97d309df25
import model.customer.Customer;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
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
    private final Shop shop; // the place where the order will be collected
    private double orderAmount; // the order amount

    public Order(int id, Customer customer, Date date, Shop shop) {
        this.id = id;
        this.customer = customer;
        this.cart = customer.getCart(); // we save the cart in the order

        this.date = new Date();
        this.shop = shop;
        this.orderAmount= 0;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
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

    public Shop getShop() {
        return shop;
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

    @Override
    public String toString(){

        DecimalFormat price = new DecimalFormat ( ) ;
        price.setMaximumFractionDigits (2) ; //arrondi à 2 chiffres apres la virgules
        return ("The order №" + this.getId() + " has been placed, for the shop at" + this.getShop().getAdress()+", "
                +this.getShop().getCity() + ", final amount: " + price.format(this.getOrderAmount())+ " €");
    }



}
