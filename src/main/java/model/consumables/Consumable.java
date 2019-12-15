package model.consumables;

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

}
