package model;

import model.customer.Customer;
import model.discount.Discount;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Order {
    private final int id; // just a  random number given to every order
    private final Cart cart;
    private final Customer customer;
    private final Date date; // the order date and hour
    private final Shop shop; // the place where the order will be collected
    private double totalPrice; // the order amount
    private int orderStatus; // status of the order

    public Order(int id, Customer customer, Date date, Shop shop) {
        this.id = id;
        this.customer = customer;
        this.cart = customer.getCart(); // we save the cart in the order
        this.orderStatus = 0;
        this.date = new Date();
        this.shop = shop;
        this.totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalPrice(Discount discount) {
        return totalPrice - totalPrice * discount.getRate();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Order)) return false;
        return (((Order) obj).getId() == id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    @Override
    public String toString(){
        DecimalFormat price = new DecimalFormat();
        price.setMaximumFractionDigits(2);
        return ("The order №" + id + " has been placed, for the shop at " + shop.getAddress() + ", "
                + shop.getCity() + ", final price: " + price.format(totalPrice) + " €");
    }
}
