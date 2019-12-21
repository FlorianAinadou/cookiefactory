package model;

import model.consumables.CookieComponent;
import utils.Lib;
import utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Recipe {
    // parameters
    private String name;
    private CookieComponent cooking = null;
    private CookieComponent mix = null;
    private CookieComponent dough = null;
    private CookieComponent flavour = null;
    private ArrayList<CookieComponent> toppings = new ArrayList<>();
    private double price = 0;
    private double marginPrice;
    private boolean isPersonalized;
    private int nbToppings = 0;

    public Recipe(String n, double mp, List<CookieComponent> components, boolean isPersonalized) {
        this.isPersonalized = isPersonalized;
        this. name = n;
        components.forEach(c -> {
            switch (c.getType()) {
                case Lib.ComponentType.DOUGH:
                    if (dough == null) {
                        this.dough = c;
                        price += c.getPrice();
                    } else recipeError(1, "dough");
                    break;
                case Lib.ComponentType.FLAVOUR:
                    if (flavour == null) {
                        price += c.getPrice();
                        this.flavour = c;
                    } else recipeError(1, "flavour");
                    break;
                case Lib.ComponentType.MIX:
                    if (mix == null) {
                        price += c.getPrice();
                        this.mix = c;
                    } else recipeError(1, "mix");
                    break;
                case Lib.ComponentType.COOKING:
                    if (cooking == null) {
                        price += c.getPrice();
                        this.cooking = c;
                    } else recipeError(1, "cooking");
                    break;
                case Lib.ComponentType.TOPPING:
                    if (nbToppings >= 3) {
                        recipeError(3, "toppings");
                    } else {
                        toppings.add(c);
                        nbToppings++;
                    }
                    break;
                default:
                    Log.print("The ingredient : " + c.getName() + " has an incorrect type and has not been added to the recipe");
                    break;
            }
        });
        marginPrice = mp;
        price += mp;
    }

    public List<CookieComponent> getIngredients() {
        List<CookieComponent> ingredients = new ArrayList<>();
        if (dough != null) ingredients.add(dough);
        if (cooking != null) ingredients.add(cooking);
        if (mix != null) ingredients.add(mix);
        if (flavour != null) ingredients.add(flavour);
        if (toppings.size() != 0) ingredients.addAll(toppings);
        return ingredients;
    }

    public boolean isPersonalized() {
        return isPersonalized;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CookieComponent getCooking() {
        return cooking;
    }

    public CookieComponent getMix() {
        return mix;
    }

    public double getPrice() {
        return price;
    }

    public double getMarginPrice() {
        return marginPrice;
    }

    public void setCooking(CookieComponent cooking) {
        price -= this.cooking.getPrice();
        this.cooking = cooking;
        price += this.cooking.getPrice();
    }

    public void setMix(CookieComponent mix) {
        price -= this.mix.getPrice();
        this.mix = mix;
        price += this.mix.getPrice();
    }

    public CookieComponent getDough() {
        return dough;
    }

    public void setDough(CookieComponent dough) {
        price -= this.dough.getPrice();
        this.dough = dough;
        price += this.dough.getPrice();
    }

    public CookieComponent getFlavour() {
        return flavour;
    }

    public void setFlavour(CookieComponent flavour) {
        price -= this.flavour.getPrice();
        this.flavour = flavour;
        price += this.flavour.getPrice();
    }

    public ArrayList<CookieComponent> getToppings() {
        return toppings;
    }

    private void recipeError(int limit, String componentName) {
        Log.print("You can't pick more than " + limit + " " + componentName + ", the component has not been added");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Recipe)) return false;
        if (((Recipe) obj).getIngredients().size() == this.getIngredients().size() &&
        ((Recipe) obj).getCooking() == this.cooking &&
        ((Recipe) obj).getDough() == this.dough &&
        ((Recipe) obj).getMix() == this.mix &&
        ((Recipe) obj).getFlavour() == this.flavour &&
        ((Recipe) obj).getToppings() == this.toppings) return true;
        return name.equals(((Recipe) obj).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }
}
