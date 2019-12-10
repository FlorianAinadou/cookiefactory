package model.customer;


//import com.sun.istack.internal.Nullable;

import model.Cart;
import model.consumables.Consumable;

import java.util.Objects;
import java.util.Random;

import static api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;

//import org.jetbrains.annotations.Nullable;

/**
 * @author Aldric DUCREUX
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public abstract class Customer {
    private Cart cart; // every model.customer has a cart
    // basic information that even unregistered users need to provide
    private String firstName;
    private String lastName;
    private String tel;
    private String email;
    protected int seniority;

    public double getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(double walletAmount) {
        this.walletAmount = walletAmount;
    }

    private double walletAmount;

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

    public static Customer random(){
        return FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
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

    /**
     * Want to know if the customer is registered
     */
    public abstract boolean isRegistered();


    public int getSeniority() {
        return this.seniority;
    }
}
