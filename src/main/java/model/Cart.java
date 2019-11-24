package model;

import model.cookie.Cookie;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Lydia BARAUKOVA
 */
public class Cart {
    private Map<Cookie,Integer> items;
    private double totalPrice;
    //Used to know how many cookies our cart could contain
    private int cookiesNumber=0;

    public Cart() {
        items = new HashMap<>();
        totalPrice = 0;
    }

    public Map<Cookie, Integer> getItems(){ return items; } // returns all the items in the basket

    public double getTotalPrice(){ return totalPrice; } // returns total price

    public int getCookiesNumber(){
        return cookiesNumber ;
    } //returns cookies' number in the cart

    public String toString() { // builds a String describing the contents of the cart
        String s = "\nCart:\n";
        for(Map.Entry<Cookie, Integer> entry : items.entrySet()) {
            Cookie cookie = entry.getKey();
            Integer quantity = entry.getValue();
            s += cookie.getName() + " " + cookie.getUnitPriceEuro() + "€ x" + quantity + "\n";
        }
        return s;
    }

    public void addCookies(Cookie cookie, Integer quantity) {
        if (items.containsKey(cookie)) { // if the model.cookie is already in the cart
            increaseQuantityBy(cookie, quantity); // we increase the quantity of this item
        } else { // if not
            items.put(cookie, quantity); // we add the new item
            totalPrice += quantity*cookie.getUnitPriceEuro(); // and update the total price
        }
        cookiesNumber+= quantity;
    }

    private void increaseQuantityBy(Cookie cookie, Integer quantity) {
        items.put(cookie, items.get(cookie)+quantity); // we update the quantity
        totalPrice += quantity*cookie.getUnitPriceEuro(); // and the total price
    }

    public void increaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)+1);
        totalPrice += cookie.getUnitPriceEuro();
    }
    public void decreaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)-1);
        totalPrice -= cookie.getUnitPriceEuro();
    }

    public void removeItem(Cookie cookie) { // removes a certain model.cookie from the cart
        totalPrice -= items.get(cookie)*cookie.getUnitPriceEuro();
        items.remove(cookie);
    }
    public void emptyCart() { // empties the cart
        items.clear();
    }



}
