package cookie;

import java.util.List;

import cookie.parameters.*;

/**
 * @author Lydia Baraukova
 */
public class Cookie {

    protected Dough dough;
    protected Cooking cooking;
    protected Flavour flavour;
    protected Mix mix;
    protected List<Topping> toppings;
    protected double unitPriceEuro;

    public Cookie(Dough d, Cooking c, Flavour f, Mix m, List<Topping> t, double p) {
        dough = d;
        cooking = c;
        flavour = f;
        mix = m;
        toppings = t;
        unitPriceEuro = p;
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

    public double getUnitPriceEuro() { return unitPriceEuro; }
    void setUnitPriceEuro(double p) { unitPriceEuro = p; }
}
