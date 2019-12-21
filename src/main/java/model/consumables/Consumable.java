package model.consumables;

import java.util.Map;

/**
 * Cause both cookies and drinks are consumables
 */
public abstract class Consumable {

    protected double price;

    public Consumable(double price) {
        this.price = price;
    }

    protected String name = "";

    public double getPrice() { return this.price; }

    @Override
    public String toString() {
        return this.name  + "  " + " Price: "+ this.price;
    }

    public abstract String getName();

    public abstract boolean isCookie();

    public abstract boolean isCookiePack();

    public abstract boolean isDrink();

    public abstract Map<Consumable, Integer> getItemPack(); // returns all the items in the pack

}
