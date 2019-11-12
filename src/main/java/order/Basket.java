package order;

import cookie.Cookie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lydia BARAUKOVA
 */
public class Basket {

    private Map<Cookie,Integer> items;
    private double totalPrice;
    private String basketContenance;

    public Basket() {
        items = new HashMap<>();
        totalPrice = 0;
        basketContenance="";
    }

    void addCookie(Cookie cookie) { addCookies(cookie, 1); }

    public void addCookies(Cookie cookie, Integer quantity) {
        if (items.containsKey(cookie)) {
            increaseQuantityBy(cookie, quantity);
        } else {
            items.put(cookie, quantity);
        }
        basketContenance+= cookie.toString() +" "+ quantity +"\n" ;
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

    public double getTotalPrice(){
        return this.totalPrice;
    }


    public Map<Cookie, Integer> getItemes(){
        return this.items;
    }

    /**
     * Some way to see what do your basket contain
     * @return
     */
    public String showBasket(){
        return basketContenance;

    }
}
