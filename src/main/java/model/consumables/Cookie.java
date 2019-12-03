package model.consumables;

import model.RecipeCookie;

/**
 * @author Lydia Baraukova
 */
public class Cookie extends Consumable {

    protected RecipeCookie recipe;

    public Cookie(RecipeCookie r) {
        recipe = r;
    }

    public RecipeCookie getRecipe() { return recipe; }


    public double getPrice() { return  recipe.getPrice(); }

    @Override
    public String toString() {
        return recipe.getName();
    }

    @Override
    public String getName() {
        return this.toString();
    }
}
