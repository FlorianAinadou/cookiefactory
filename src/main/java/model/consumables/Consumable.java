package model.consumables;

import java.util.Map;

/**
 * Cause both cookies and drinks are consumables
 */
public abstract class Consumable{

    protected String name = "";

    public abstract double getPrice();

    @Override
    public String toString() {
        return this.name  + "  " + " Price: "+ this.getPrice();
    }

    public abstract String getName();

    public abstract boolean isCookie();

    public abstract boolean isCookiePack();

    public abstract boolean isDrink();

    public abstract Map<Consumable, Integer> getItemPack(); // returns all the items in the pack

}
