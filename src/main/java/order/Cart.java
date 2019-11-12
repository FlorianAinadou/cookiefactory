package order;

import cookie.Cookie;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Lydia BARAUKOVA
 */
public class Cart {

    private Map<Cookie,Integer> items;
    private double totalPrice;

    public Cart() {
        items = new HashMap<>();
        totalPrice = 0;
    }

    void addCookies(Cookie cookie, Integer quantity) {
        if (items.containsKey(cookie)) { // if the cookie is already in the cart
            increaseQuantityBy(cookie, quantity); // we increase the quantity of this item
        } else { // if not
            items.put(cookie, quantity); // we add the new item
            totalPrice += quantity*cookie.getUnitPriceEuro(); // and update the total price
        }
    }

    void increaseQuantityBy(Cookie cookie, Integer quantity) {
        items.put(cookie, items.get(cookie)+quantity); // we update the quantity
        totalPrice += quantity*cookie.getUnitPriceEuro(); // and the total price
    }

    void removeItem(Cookie cookie) { // removes a certain cookie from the cart
        totalPrice -= items.get(cookie)*cookie.getUnitPriceEuro();
        items.remove(cookie);
    }

    void emptyCart() { // empties the cart
        items.clear();
    }

    void increaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)+1);
        totalPrice += cookie.getUnitPriceEuro();
    }
    void decreaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)-1);
        totalPrice -= cookie.getUnitPriceEuro();
    }
}
