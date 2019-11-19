package model.cookie;

/**
 * @author Lydia Baraukova
 */
public class Cookie {

    protected Recipe recipe;

    public Cookie(Recipe r) {
        recipe = r;
    }

    public Recipe getRecipe() { return recipe; }

    @Override
    public String toString() {
        return recipe.getName();
    }
}
