package model.consumables;

import model.Recipe;

/**
 * @author Lydia Baraukova
 */
public class Cookie extends Consumable {

    protected Recipe recipe;

    public Cookie(Recipe r) {
        recipe = r;
    }

    public Recipe getRecipe() { return recipe; }

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
