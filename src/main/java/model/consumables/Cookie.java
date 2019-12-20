package model.consumables;

import model.Recipe;

import java.util.Map;

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
}
