package model.consumables;

import java.util.HashMap;
import java.util.Map;

public class CookiesPack extends Consumable {
    private HashMap<Consumable,Integer> cookiePack;
    //private Map<Consumable,Integer> allConsumables;
    private final int cookiesNumber;
    private final double packPrice;
    private int actualNumberOfCookies;

    public CookiesPack( int cookiesNumber, double packPrice){
        this.cookiesNumber= cookiesNumber;
        this.packPrice=packPrice;
        cookiePack= new HashMap<>();
    }

    public CookiesPack(int cookiesNumber , float packPrice, Map<Consumable,Integer> allConsumables) {
        this.packPrice = packPrice;
        this.cookiesNumber = cookiesNumber;
        for (Consumable consumable: allConsumables.keySet()) {
            addConsumablesToPack(consumable, allConsumables.get(consumable));
            allConsumables.remove(consumable);
        }
        actualNumberOfCookies=0;
        cookiePack= new HashMap<>();
    }

    public void addConsumablesToPack(Consumable consumable, int quantity){

                if (cookiePack.containsKey(consumable)) { // if the model.consumables is already in the cart
                    increaseCookiesQuantityBy(consumable, quantity); // we increase the quantity of this item
                } else { // if not
                    cookiePack.put(consumable, quantity); // we add the new item
                }
                actualNumberOfCookies += quantity; // ?????
    }

    private void increaseCookiesQuantityBy(Consumable consumable, Integer quantity) {
        cookiePack.put(consumable, cookiePack.get(consumable)+quantity); // we update the quantity
    }

    @Override
    public Map<Consumable, Integer> getItemPack() {return cookiePack;} // returns all the items in the pack

    @Override
    public double getPrice() {
        return this.packPrice;
    }

    @Override
    public String getName() {
        return "A cookies Pack of "+ cookiesNumber + " cookies";
    }

    @Override
    public boolean isCookie() {
        return false;
    }
    @Override
    public boolean isCookiePack() {
        return true;
    }
}
