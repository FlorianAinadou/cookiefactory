package model.customer;

import model.Cart;
import model.CinemaTicket;
import model.consumables.Consumable;

import java.util.Objects;

/**
 * @author Aldric DUCREUX
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public abstract class Customer {

    protected Cart cart; // every customer has a cart

    // basic information for all users
    protected String firstName;
    protected String lastName;
    protected String tel;
    protected String email;
    protected CinemaTicket cinemaTicket = null;

    protected int seniority;
    protected double walletAmount;

    Customer(String firstName, String lastName, String tel, String email, double walletAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email = email;
        this.cart = new Cart();
        this.walletAmount = walletAmount;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getTel() { return tel; }
    public void setTel(String t) { tel = t; }
    public String getEmail() { return email; }
    public void setEmail(String e) { email = e; }

    public CinemaTicket getCinemaTicket() { return cinemaTicket; }
    public void setCinemaTicket(CinemaTicket t) { cinemaTicket = t; }

    public double getWalletAmount() {
        return walletAmount;
    }
    public void setWalletAmount(double walletAmount) {
        this.walletAmount = walletAmount;
    }

    public Cart getCart() { return cart; }
    public void addConsumables(Consumable consumable, Integer quantity) {
        cart.addConsumables(consumable, quantity);
    }
    public void showCart(){
        System.out.println(cart.toString());
    }
    public void emptyCart() {
        cart.emptyCart();
    }

    public int getSeniority() {
        return this.seniority;
    }

    @Override
    public boolean equals( Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Customer)) return false;
        return (((Customer) obj).firstName.equals(this.firstName) && ((Customer) obj).lastName.equals(this.lastName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public abstract boolean isRegistered();
}
