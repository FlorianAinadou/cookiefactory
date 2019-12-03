package model.consumables;

import model.consumables.ingredients.Dough;
import model.consumables.ingredients.Flavour;
import model.consumables.ingredients.Topping;
import model.consumables.parameters.Cooking;
import model.consumables.parameters.Mix;

import java.util.List;

/**
 * @author Lydia BARAUKOVA
 */
public class Recipe {
    // paramètres
    private String name;
    private Cooking cooking;
    private Mix mix;
    private double price;
    // ingrédients
    private Dough dough;
    private Flavour flavour;
    private List<Topping> toppings;

    public Recipe(String n, Dough d, Cooking c, Flavour f, Mix m, List<Topping> t) {
        name = n;
        dough = d;
        cooking = c;
        flavour = f;
        mix = m;
        toppings = t;
        price = dough.getPrice() + flavour.getPrice();
        toppings.forEach(topping -> price += topping.getPrice());
    }

    public String getName() { return name; }
    double getPrice() { return  price; }

    Dough getDough() { return dough; }
    void setDough(Dough d) { dough = d; }

    Cooking getCooking() { return cooking; }
    void setCooking(Cooking c) { cooking = c; }

    Flavour getFlavour() { return flavour; }
    void setFlavour(Flavour f) { flavour = f; }

    Mix getMix() { return mix; }
    void setMix(Mix m) { mix = m; }

    List<Topping> getToppings() { return toppings; }
    void removeAllToppings() { toppings.removeAll(toppings); }
    void removeTopping(Topping t) { toppings.remove(t); }
    void addTopping(Topping t) { toppings.add(t); }
}
