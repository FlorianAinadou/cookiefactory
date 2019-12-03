package model;


import model.consumables.CookieComponent;
import utils.Lib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lydia BARAUKOVA
 */
public class Recipe {
    // paramètres
    private String name;
    private CookieComponent cooking = null;
    private CookieComponent mix = null;
    private double price = 0;
    // ingrédients
    private CookieComponent dough = null;
    private CookieComponent flavour = null;
    private ArrayList<CookieComponent> toppings = new ArrayList<>();

    private void errorRecipe(String name) {
        System.out.println("The recipe is incorrect, you can't pick more than one " + name + ", the ingredient has not been added");
    }

    public Recipe(String n, List<CookieComponent> composants) {
        name = n;
        composants.forEach(c -> {
            switch (c.getType()) {
                case Lib.ComponentType.DOUGH:
                    if (dough == null) {
                        this.dough = c;
                        price += c.getPrice();
                    } else {
                        errorRecipe("dough");
                    }
                    break;
                case Lib.ComponentType.FLAVOUR:
                    if (flavour == null) {
                        price += c.getPrice();
                        this.flavour = c;
                    } else {
                        errorRecipe("flavour");
                    }
                    break;
                case Lib.ComponentType.MIX:
                    if (mix == null) {
                        price += c.getPrice();
                        this.mix = c;
                    } else {
                        errorRecipe("mix");
                    }
                    break;
                case Lib.ComponentType.COOKING:
                    if (cooking == null) {
                        price += c.getPrice();
                        this.cooking = c;
                    } else {
                        errorRecipe("cooking");
                    }
                    break;
                case Lib.ComponentType.TOPPING:
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

    public CookieComponent getCooking() {
        return cooking;
    }

    public void setCooking(CookieComponent cooking) {
        this.cooking = cooking;
    }

    public CookieComponent getMix() {
        return mix;
    }

    public void setMix(CookieComponent mix) {
        this.mix = mix;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CookieComponent getDough() {
        return dough;
    }

    public void setDough(CookieComponent dough) {
        this.dough = dough;
    }

    public CookieComponent getFlavour() {
        return flavour;
    }

    public void setFlavour(CookieComponent flavour) {
        this.flavour = flavour;
    }

    public ArrayList<CookieComponent> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<CookieComponent> toppings) {
        this.toppings = toppings;
    }
}
