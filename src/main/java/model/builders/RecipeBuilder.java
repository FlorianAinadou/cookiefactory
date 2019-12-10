package model.builders;

import model.Recipe;
import model.consumables.CookieComponent;
import utils.Lib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Virgile Fantauzzi
 */
public class RecipeBuilder {

    private final double MARGIN_COD = 1.2;

    // paramètres
    private String name = "";
    private boolean isPerso;
    private CookieComponent cooking = null;
    private CookieComponent mix = null;
    private double price = 0;
    private double rate = 1;
    private double marginPrice = 0;
    // ingrédients
    private CookieComponent dough = null;
    private CookieComponent flavour = null;
    private ArrayList<CookieComponent> toppings = new ArrayList<>();

    public RecipeBuilder(double rate) {
        this.rate = rate;
    }

    public Recipe buildRecipe() {
        return new Recipe(name, cooking, mix, price * rate, marginPrice, dough, flavour, toppings);
    }

    private void errorRecipe(String name) {
        System.out.println("The recipe is incorrect, you can't pick more than one " + name + ", the ingredient has not been added");
    }

    public RecipeBuilder name(String _name) {
        this.name = _name;
        return this;
    }

    public RecipeBuilder cooking(CookieComponent cooking) {
        if (this.cooking == null) {
            this.cooking = cooking;
            price += cooking.getPrice();
        } else {
            errorRecipe(cooking.getName());
        }
        return this;
    }

    public RecipeBuilder mix(CookieComponent mix) {
        if (this.mix == null) {
            this.mix = mix;
            price += mix.getPrice();

        } else {
            errorRecipe(mix.getName());
        }
        return this;
    }

    public RecipeBuilder dough(CookieComponent dough) {
        if (this.dough == null) {
            this.dough = dough;
            price += dough.getPrice();

        } else {
            errorRecipe(dough.getName());
        }
        return this;
    }

    public RecipeBuilder flavour(CookieComponent flavour) {
        if (this.flavour == null) {
            this.flavour = flavour;
            price += flavour.getPrice();

        } else {
            errorRecipe(flavour.getName());
        }
        return this;
    }

    public RecipeBuilder marginPrice(double marginPrice) {
        this.marginPrice = marginPrice;
        price += marginPrice;
        return this;
    }

    public RecipeBuilder toppings(ArrayList<CookieComponent> toppings) {
        this.toppings.addAll(toppings);
        toppings.forEach(c -> price += c.getPrice());
        return this;
    }
}