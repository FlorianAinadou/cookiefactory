package model.cookie;

import model.Recipe;

/**
 * @author Lydia Baraukova
 */
public class Cookie {

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
}
