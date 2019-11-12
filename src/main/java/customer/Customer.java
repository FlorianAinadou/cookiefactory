package customer;

import cookie.Cookie;
import order.Cart;
import order.OrderManager;
import order.Place;

import java.util.Date;

/**
 * @author Aldric DUCREUX
 * @author Lydia BARAUKOVA
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
    public int placeOrder(OrderManager om, Date date, Place place){
        return om.placeOrder(this, date, place);
    }
    public void emptyCart() {
        cart.emptyCart();
    }
}
