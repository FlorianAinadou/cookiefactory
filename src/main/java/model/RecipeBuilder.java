package model;

import di.Injection;
import model.consumables.CookieComponent;
import utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 * Recipe builder for creating personalized cookies
 */
public class RecipeBuilder {

    private final double MARGIN_COD = 0.2; // additional margin on personalized cookies

    // parameters
    private String name = "";
    private CookieComponent cooking = null;
    private CookieComponent mix = null;
    private CookieComponent dough = null;
    private CookieComponent flavour = null;
    private ArrayList<CookieComponent> toppings = new ArrayList<>();
    private int nbToppings = 0;

    public RecipeBuilder() {}

    public Recipe buildRecipe() {
        // without these elements we can't create a cookie
        if (dough == null) { Log.print("Missing dough"); return null; }
        else if (cooking == null) { Log.print("Missing dough"); return null; }
        else if (mix == null) { Log.print("Missing mix"); return null; }

        // we get the CoD margin from our API
        double codMargin = Injection.createCookieRepository().getCodMargin();

        // we create a list of components
        List<CookieComponent> components = new ArrayList<>();
        components.add(dough);
        components.add(cooking);
        components.add(mix);
        if (flavour != null) components.add(flavour);
        toppings.forEach(topping -> { if (topping != null) components.add(topping); });

        // and return the personalized recipe
        return new Recipe(name, codMargin, components, true);
    }

    public RecipeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RecipeBuilder addCooking(CookieComponent cooking) {
        if (this.cooking == null) this.cooking = cooking;
        else recipeError(1, "cooking");
        return this;
    }

    public RecipeBuilder addMix(CookieComponent mix) {
        if (this.mix == null) this.mix = mix;
        else recipeError(1, "mix");
        return this;
    }

    public RecipeBuilder addDough(CookieComponent dough) {
        if (this.dough == null) this.dough = dough;
        else recipeError(1, "dough");
        return this;
    }

    public RecipeBuilder addFlavour(CookieComponent flavour) {
        if (this.flavour == null) this.flavour = flavour;
        else recipeError(1, "flavour");
        return this;
    }

    public RecipeBuilder addTopping(CookieComponent topping) {
        if (nbToppings == 3) recipeError(3, "toppings");
        this.toppings.add(topping);
        nbToppings++;
        return this;
    }
    public List<CookieComponent> getToppings() { return toppings; }

    private void recipeError(int limit, String componentName) {
        Log.print("You can't pick more than " + limit + " " + componentName + ", the component has not been added");
    }
}