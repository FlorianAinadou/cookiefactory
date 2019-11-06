package order;

import cookie.Cookie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lydia BARAUKOVA
 */
public class Order {

    private Map<Cookie,Integer> items;
    private double totalPrice;

    public Order() {
        items = new HashMap<>();
        totalPrice = 0;
    }

    void addCookie(Cookie cookie) { addCookies(cookie, 1); }

    void addCookies(Cookie cookie, Integer quantity) {
        if (items.containsKey(cookie)) {
            increaseQuantityBy(cookie, quantity);
        } else {
            items.put(cookie, quantity);
        }
    }

    void increaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)+1);
        totalPrice += cookie.getUnitPriceEuro();
    }

    void increaseQuantityBy(Cookie cookie, Integer quantity) {
        items.put(cookie, items.get(cookie)+quantity);
        totalPrice += quantity*cookie.getUnitPriceEuro();
    }
    void decreaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)-1);
        totalPrice -= cookie.getUnitPriceEuro();
    }

    void removeCookies(Cookie cookie) {
        totalPrice -= items.get(cookie)*cookie.getUnitPriceEuro();
        items.remove(cookie);
    }
}
