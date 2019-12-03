package model;

import model.cookie.CookieComposant;
import model.cookie.ingredients.Const;
import model.cookie.ingredients.Dough;
import model.cookie.ingredients.Flavour;
import model.cookie.ingredients.Topping;
import model.cookie.parameters.Cooking;
import model.cookie.parameters.Mix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lydia BARAUKOVA
 */
public class RecipeCookie {
    // paramètres
    private String name;
    private CookieComposant cooking = null;
    private CookieComposant mix = null;
    private double price = 0;
    // ingrédients
    private CookieComposant dough = null;
    private CookieComposant flavour = null;
    private ArrayList<CookieComposant> toppings = new ArrayList<>();

    private void errorRecipe(String name) {
        System.out.println("The recipe is incorrect, you can't pick more than one " + name + ", the ingredient has not been added");
    }

    public RecipeCookie(String n, List<CookieComposant> composants) {
        name = n;
        composants.forEach(c -> {
            switch (c.getType()) {
                case Const.TYPE_DOUGH:
                    if (dough == null) {
                        this.dough = c;
                        price += c.getPrice();
                    } else {
                        errorRecipe("dough");
                    }
                    break;
                case Const.TYPE_FLAVOUR:
                    if (flavour == null) {
                        price += c.getPrice();
                        this.flavour = c;
                    } else {
                        errorRecipe("flavour");
                    }
                    break;
                case Const.TYPE_MIX:
                    if (mix == null) {
                        price += c.getPrice();
                        this.mix = c;
                    } else {
                        errorRecipe("mix");
                    }
                    break;
                case Const.TYPE_COOKING:
                    if (cooking == null) {
                        price += c.getPrice();
                        this.cooking = c;
                    } else {
                        errorRecipe("cooking");
                    }
                    break;
                case Const.TYPE_TOPPING:
                    toppings.add(c);
                    break;
                default:
                    System.out.println("The ingredient : " + c.getName() + " has an incorrect type and has not been added to the recipe");
                    break;
            }
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CookieComposant getCooking() {
        return cooking;
    }

    public void setCooking(CookieComposant cooking) {
        this.cooking = cooking;
    }

    public CookieComposant getMix() {
        return mix;
    }

    public void setMix(CookieComposant mix) {
        this.mix = mix;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CookieComposant getDough() {
        return dough;
    }

    public void setDough(CookieComposant dough) {
        this.dough = dough;
    }

    public CookieComposant getFlavour() {
        return flavour;
    }

    public void setFlavour(CookieComposant flavour) {
        this.flavour = flavour;
    }

    public ArrayList<CookieComposant> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<CookieComposant> toppings) {
        this.toppings = toppings;
    }
}
