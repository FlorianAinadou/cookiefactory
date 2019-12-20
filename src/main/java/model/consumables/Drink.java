package model.consumables;

import java.util.Map;

public class Drink extends Consumable {

    private final double  price;

    public Drink(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isCookie() {
        return false;
    }
    @Override
    public boolean isDrink() {
        return true;
    }
    @Override
    public boolean isCookiePack() {
        return false;
    }
    @Override
    public Map<Consumable, Integer> getItemPack() {return null;}
}
