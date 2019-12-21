package model;

import model.consumables.Consumable;
import model.consumables.Cookie;
import model.discount.Discount;
import utils.Utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lydia BARAUKOVA
 * @author Florian AINADOU
 * @author Aldric DUCREUX
 */
public class Cart implements Cloneable{
    private Map<Consumable,Integer> items;
    private double totalPrice;
    private int nbCookies; // to know how many cookies there are in the cart
    private int nbCookiesDirectlyInTheCart;
    private boolean codeEvent;

    public Cart() {
        items = new HashMap<>();
        totalPrice = 0;
        nbCookies = 0;
        nbCookiesDirectlyInTheCart=0;
    }

    public Map<Consumable, Integer> getItems() { return items; } // returns all the items in the basket
    public void setItems(Map<Consumable, Integer> newItems) { this.items = newItems; } // returns all the items in the basket
    public double getTotalPrice(){ return totalPrice; } // returns total price

    public int getNbCookies(){
        return nbCookies;
    } // returns cookies' number in the cart

    public String toString() { // builds a String describing the contents of the cart
        String s = "\nCart:\n";
        for(Map.Entry<Consumable, Integer> entry : items.entrySet()) {
            Consumable consumable = entry.getKey();
            Integer quantity = entry.getValue();
            s += (!consumable.getName().equals("")?consumable.getName(): "Personalized cookie") + " " + Utils.formatDouble(consumable.getPrice()) + "€ x" + quantity +"\n";
        }
        s += "Total price (HT):  " + Utils.formatDouble(totalPrice) + "€";
        return s;
    }

    public void addConsumables(Consumable consumable, Integer quantity) {
        if (items.containsKey(consumable)) { // if the model.consumables is already in the cart
            increaseCookiesQuantityBy(consumable, quantity); // we increase the quantity of this item
        } else { // if not
            items.put(consumable, quantity); // we add the new item
            totalPrice += quantity*consumable.getPrice(); // and update the total price
        }
        if (consumable.isCookie()){
            nbCookies += quantity; // ?????
            nbCookiesDirectlyInTheCart +=quantity;
        }
    }

    private void increaseCookiesQuantityBy(Consumable consumable, Integer quantity) {
        items.put(consumable, items.get(consumable)+quantity); // we update the quantity
        totalPrice += quantity*consumable.getPrice(); // and the total price
    }

    public void increaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)+1);
        totalPrice += cookie.getPrice();
    }
    public void decreaseQuantity(Cookie cookie) {
        items.put(cookie, items.get(cookie)-1);
        totalPrice -= cookie.getPrice();
    }

    public void removeItem(Cookie cookie) { // removes a certain model.consumables from the cart
        totalPrice -= items.get(cookie)*cookie.getPrice();
        items.remove(cookie);
    }
    public void emptyCart() { // empties the cart
        totalPrice=0;
        nbCookies =0;
        items.clear();
    }

    public static<K,V> Map<K,V> cloneMap(Map<K,V> original) {
        return original.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    @Override
    public Cart clone() throws CloneNotSupportedException {
        Cart cloneCart = (Cart) super.clone();
        cloneCart.items = cloneMap(items);
        return cloneCart;
    }

    public void setNbCookiesDirectlyInTheCart(int cookies) {
        this.nbCookiesDirectlyInTheCart=cookies;
    }

    public void recalculateFinalPrice(){
        double price=0;
        for (Consumable consumable : items.keySet()  ) {
            price+= items.get(consumable) * consumable.getPrice();
        }
        this.totalPrice= price;
    }

    public int getNbCookiesDirectlyInTheCart() {
        return nbCookiesDirectlyInTheCart;
    }


    public void applyReductionOnConsumable(Discount discount, Consumable consumable){
        if (items.containsKey(consumable)) {
            totalPrice -= (consumable.getPrice()) * (items.get(consumable));
            totalPrice += (consumable.getPrice()) * (items.get(consumable)) * (1 - discount.getRate());
        }
    }
}
