package model.consumables;

import java.util.Map;

public class CookiesPack extends Consumable {
    private Map<Consumable,Integer> cookiePack;
    //private Map<Consumable,Integer> allConsumables;
    private final int cookiesNumber;
    private final float packPrice;
    private int actualNumberOfCookies;

    public CookiesPack(int cookiesNumber , float packPrice, Map<Consumable,Integer> allConsumables) {
        this.packPrice = packPrice;
        this.cookiesNumber = cookiesNumber;
        for (Consumable consumable: allConsumables.keySet()) {
            addConsumablesToPack(consumable, allConsumables.get(consumable));
            allConsumables.remove(consumable);
        }
        actualNumberOfCookies=0;
    }

    public void addConsumablesToPack(Consumable consumable, int quantity){
            if (cookiePack.containsKey(consumable) ) { // if the model.consumables is already in the cart
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
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isCookie() {
        return false;
    }
}
