package model;


import model.consumables.CookieComponent;
import utils.Lib;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Lydia BARAUKOVA
 */
public class Recipe {
    // paramètres
    private String name;
    private CookieComponent cooking = null;
    private CookieComponent mix = null;
    private double price = 0;
    private double marginPrice = 0;

    // ingrédients
    private CookieComponent dough = null;
    private CookieComponent flavour = null;
    private ArrayList<CookieComponent> toppings = new ArrayList<>();

    public Recipe(String name, CookieComponent cooking, CookieComponent mix, double price, double marginPrice, CookieComponent dough, CookieComponent flavour, ArrayList<CookieComponent> toppings) {
        this.name = name;
        this.cooking = cooking;
        this.mix = mix;
        this.price = price;
        this.marginPrice = marginPrice;
        this.dough = dough;
        this.flavour = flavour;
        this.toppings = toppings;
    }

    private void errorRecipe(String name) {
        System.out.println("The recipe is incorrect, you can't pick more than one " + name + ", the ingredient has not been added");
    }

    public Recipe(String n, double mp, List<CookieComponent> composants) {
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
        marginPrice = mp;
        price += mp;
    }

    public void setPriceMargin(double marginPrice) {
        this.price -= this.marginPrice;
        this.marginPrice = marginPrice;
        this.price += this.marginPrice;
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

    public CookieComponent getMix() {
        return mix;
    }

    public double getPrice() {
        DecimalFormat price = new DecimalFormat();
        price.setMaximumFractionDigits(2); //arrondi à 2 chiffres apres la virgules
        return this.price;
    }

    public void setCooking(CookieComponent cooking) {
        price -= this.cooking.getPrice();
        this.cooking = cooking;
        price -= this.cooking.getPrice();
    }

    public void setMix(CookieComponent mix) {
        price -= this.mix.getPrice();
        this.mix = mix;
        price -= this.mix.getPrice();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CookieComponent getDough() {
        return dough;
    }

    public void setDough(CookieComponent dough) {
        price -= this.dough.getPrice();
        this.dough = dough;
        price -= this.dough.getPrice();
    }

    public CookieComponent getFlavour() {
        return flavour;
    }

    public void setFlavour(CookieComponent flavour) {
        price -= this.flavour.getPrice();
        this.flavour = flavour;
        price -= this.flavour.getPrice();
    }

    public ArrayList<CookieComponent> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<CookieComponent> toppings) {
        this.toppings.forEach(c -> price -= c.getPrice());
        this.toppings = toppings;
        this.toppings.forEach(c -> price += c.getPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Recipe)) return false;
        return name.equals(((Recipe) obj).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }
}
