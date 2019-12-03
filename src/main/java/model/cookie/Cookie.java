package model.cookie;

import model.RecipeCookie;

/**
 * @author Lydia Baraukova
 */
public class Cookie {

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
}
