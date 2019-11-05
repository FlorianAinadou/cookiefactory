package main.java.cookie;

import java.util.List;

import main.java.cookie.parameters.*;

/**
 * @author Lydia Baraukova
 */
public class Cookie {

    protected Dough dough;
    protected Cooking cooking;
    protected Flavour flavour;
    protected Mix mix;
    protected List<Topping> toppings;

    public Cookie(Dough d, Cooking c, Flavour f, Mix m, List<Topping> t) {
        dough = d;
        cooking = c;
        flavour = f;
        mix = m;
        toppings = t;
    }

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
