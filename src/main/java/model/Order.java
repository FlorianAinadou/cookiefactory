package model;


import model.customer.Customer;
import model.discount.Discount;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//import org.jetbrains.annotations.Nullable;

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
    private List<Discount> discountsYouCouldApply;

    public int getOrderStatu() {
        return orderStatu;
    }

    public void setOrderStatu(int orderStatu) {
        this.orderStatu = orderStatu;
    }

    private int orderStatu; // statu of the order

    public Order(int id, Customer customer, Date date, Shop shop, List<Discount> discounts) {
        this.id = id;
        this.customer = customer;
        this.cart = customer.getCart(); // we save the cart in the order
        this.orderStatu = 0;
        this.date = new Date();
        this.shop = shop;
        this.orderAmount= 0;
        discountsYouCouldApply= discounts;
    }


    public double getOrderAmount() {
        return orderAmount;
    }

    public double getOrderAmount(Discount discount) {
        return orderAmount-orderAmount*discount.getRate();
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

    public List<Discount> getDiscountsYouCouldApply() {
        return discountsYouCouldApply;
    }

    @Override
    public boolean equals(Object obj) {
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
        return ("The order №" + this.getId() + " has been placed, for the shop at " + this.getShop().getAdress()+", "
                +this.getShop().getCity() + ", final amount: " + price.format(this.getOrderAmount())+ " €");
    }



}
