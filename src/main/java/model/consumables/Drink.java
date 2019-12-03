package model.consumables;

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
}
