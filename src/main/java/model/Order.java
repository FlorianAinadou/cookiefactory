package model;

import model.consumables.Cookie;
import model.customer.Customer;
import model.discount.Discount;
import utils.Utils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Florian AINADOU
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Order {
    private final int id; // just a  random number given to every order
    private  Cart cart;
    private final Customer customer;
    private final Date date, pickupDate; // date of the order and date of the pickup
    private final Shop shop; // the place where the order will be collected
    private double totalPrice; // the order amount
    private int orderStatus; // status of the order
    private List<Discount> discountsYouCouldApply;

    public Order(int id, Customer customer, Date date, Date pickupDate, Shop shop, List<Discount> discounts) {
        this.id = id;
        this.customer = customer;
        this.cart = customer.getCart(); // we save the cart in the order
        this.orderStatus = 0;
        this.date = date;
        this.pickupDate = pickupDate;
        this.shop = shop;
        this.totalPrice = cart.getTotalPrice();
        // if the customer has a cinema ticket for today and has ordered 5 or more cookies, he gets 2 free cookies
        if (customer.getCinemaTicket() != null) {
                if (Utils.sameDay(date, customer.getCinemaTicket().getMovieDate()) &&
                        cart.getNbCookies() >= 5) {
                    cart.addConsumables(new Cookie(shop.getRecipeOfTheMonth()), 2);
                }
        }
        discountsYouCouldApply= discounts;
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
    public void setCart(Cart newCart) { this.cart = newCart;}
    public Customer getCustomer() {
        return customer;
    }
    public Date getDate() {
        return date;
    }
    public Date getPickupDate() { return pickupDate; }
    public Shop getShop() {
        return shop;
    }

    public int getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(int orderStatus) { this.orderStatus = orderStatus; }

    public List<Discount> getDiscountsYouCouldApply() { return discountsYouCouldApply; }

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
        return ("The order №" + id + " has been placed, for the shop at " + shop.getAddress() + ", "
                + shop.getCity() + ", final price: " + Utils.formatDouble(totalPrice) + " €");
    }
}
