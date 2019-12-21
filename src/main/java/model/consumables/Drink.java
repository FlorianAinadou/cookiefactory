package model.consumables;

import java.util.Map;

public class Drink extends Consumable {

    public Drink(double price, String name) {
        super(price);
        this.name = name;
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
