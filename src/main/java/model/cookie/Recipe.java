package model.cookie;

import model.cookie.ingredients.Dough;
import model.cookie.ingredients.Flavour;
import model.cookie.ingredients.Topping;
import model.cookie.parameters.Cooking;
import model.cookie.parameters.Mix;

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

    public double getMarginPrice() {
        return marginPrice;
    }

    public void setMarginPrice(double marginPrice) {
        this.price -= this.marginPrice;
        this.marginPrice = marginPrice;
        this.price += marginPrice;
    }

    private double marginPrice;
    // ingrédients
    private Dough dough;
    private Flavour flavour;
    private List<Topping> toppings;

    public Recipe(String n, double mp, Dough d, Cooking c, Flavour f, Mix m, List<Topping> t) {
        name = n;
        dough = d;
        cooking = c;
        flavour = f;
        mix = m;
        toppings = t;
        marginPrice = mp;
        price = dough.getPrice() + flavour.getPrice();
        toppings.forEach(topping -> price += topping.getPrice());
        price += marginPrice;
    }

    public String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    Dough getDough() {
        return dough;
    }

    void setDough(Dough d) {
        dough = d;
    }

    Cooking getCooking() {
        return cooking;
    }

    void setCooking(Cooking c) {
        cooking = c;
    }

    Flavour getFlavour() {
        return flavour;
    }

    void setFlavour(Flavour f) {
        flavour = f;
    }

    Mix getMix() {
        return mix;
    }

    void setMix(Mix m) {
        mix = m;
    }

    List<Topping> getToppings() {
        return toppings;
    }

    void removeAllToppings() {
        toppings.removeAll(toppings);
    }

    void removeTopping(Topping t) {
        toppings.remove(t);
    }

    void addTopping(Topping t) {
        toppings.add(t);
    }
}
