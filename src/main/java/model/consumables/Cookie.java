package model.consumables;

import model.Recipe;

import java.util.Map;
import java.util.Objects;

/**
 * @author Lydia Baraukova
 */
public class Cookie extends Consumable {

    protected Recipe recipe;

    public Cookie(Recipe r) {
        super(/*r == null ? 0 : */r.getPrice());
        recipe = r;
    }

    public Recipe getRecipe() { return recipe; }

    @Override
    public String toString() {
        return recipe.getName();
    }

    @Override
    public String getName() {
        return this.toString();
    }

    @Override
    public boolean isCookie() {
        return true;
    }
    
    @Override
    public boolean isDrink() {
        return false;
    }

    @Override
    public boolean isCookiePack() {
        return false;
    }
    @Override
    public Map<Consumable, Integer> getItemPack() {return null;}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Cookie)) return false;
        return ((Cookie) obj).getRecipe().equals(this.recipe);
    }
}
