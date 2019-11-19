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
    }

    public String getName() { return name; }

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
