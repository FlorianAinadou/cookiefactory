package customer;

import com.sun.istack.internal.Nullable;
import cookie.Cookie;
import order.Cart;
import order.OrderManager;
import order.Place;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;

/**
 * @author Aldric DUCREUX
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public abstract class Customer {
    private Cart cart; // every customer has a cart
    // basic information that even unregistered users need to provide
    private String firstName;
    private String lastName;
    private String tel;
    private String email;

    Customer(String firstName, String lastName, String tel, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email = email;
        this.cart = new Cart();
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getTel() { return tel; }
    public void setTel(String t) { tel = t; }
    public String getEmail() { return email; }
    public void setEmail(String e) { email = e; }
    public Cart getCart() { return cart; }

    public void addCookies(Cookie cookie, Integer quantity) {
        cart.addCookies(cookie, quantity);
    }
    public void showCart(){
        System.out.println(cart.toString());
    }

    //Fonction déprécié, passer par le repository
    public int placeOrder(OrderManager om, Date date, Place place){
        return om.placeOrder(this, date, place);
    }

    public void emptyCart() {
        cart.emptyCart();
    }

    public static Customer random(){
        return FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Customer)) return false;
        return (((Customer) obj).firstName.equals(this.firstName) && ((Customer) obj).lastName.equals(this.lastName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
