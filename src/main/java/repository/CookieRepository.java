package repository;

import api.ApiService;
import model.Recipe;
import model.consumables.Cookie;
import model.consumables.CookieComponent;

import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 */

public class CookieRepository {

    private final ApiService apiService;

    public CookieRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Map<String, Recipe> getCookieRecipes() {
        return apiService.getCookieRecipes();
    }

    public Map<String, CookieComponent> getCookieDough() {
        return apiService.getCookieDough();
    }

    public Map<String, CookieComponent> getCookieTopping() {
        return apiService.getCookieTopping();
    }

    public Map<String, CookieComponent> getCookieMix() {
        return apiService.getCookieMix();
    }

    public Map<String, CookieComponent> getCookieCooking() {
        return apiService.getCookieCooking();
    }

    public Map<String, CookieComponent> getCookieFlavour() {
        return apiService.getCookieFlavour();
    }

    void changeMarginTopping(String name, double value) {
        Recipe rec = getCookieRecipes().get(name);
        rec.setMarginPrice(value);
        addRecipe(name, rec);
    }

    void changeMarginDough(String name, double value) {
        CookieComponent rec = getCookieDough().get(name);
        rec.setPrice(value);
        addDough(name, rec);
    }

    void changeMarginMix(String name, double value) {
        CookieComponent rec = getCookieMix().get(name);
        rec.setPrice(value);
        addMix(name, rec);
    }

    void changeMarginCooking(String name, double value) {
        CookieComponent rec = getCookieCooking().get(name);
        rec.setPrice(value);
        addCooking(name, rec);
    }

    void changeMarginFlavour(String name, double value) {
        CookieComponent rec = getCookieFlavour().get(name);
        rec.setPrice(value);
        addFlavour(name, rec);
    }

    void changeMarginRecipe(String name, double value) {
        Recipe rec = getCookieRecipes().get(name);
        rec.setMarginPrice(value);
        addRecipe(name, rec);
    }

    void addRecipe(String name, Recipe recipe) {
        apiService.addRecipe(name, recipe);
    }

    void deleteRecipe(String name) {
        apiService.deleteRecipe(name);
    }

    void addMix(String name, CookieComponent mix) {
        apiService.addMix(name, mix);
    }

    void deleteMix(String name) {
        apiService.deleteMix(name);
    }

    void addTopping(String name, CookieComponent topping) {
        apiService.addTopping(name, topping);
    }

    void deleteTopping(String name) {
        apiService.deleteTopping(name);
    }

    void addDough(String name, CookieComponent dough) {
        apiService.addDough(name, dough);
    }

    void deleteDough(String name) {
        apiService.deleteDough(name);
    }

    void addCooking(String name, CookieComponent cooking) {
        apiService.addCooking(name, cooking);
    }

    void deleteCooking(String name) {
        apiService.deleteCooking(name);
    }

    void addFlavour(String name, CookieComponent flavour) {
        apiService.addFlavour(name, flavour);
    }

    void deleteFlavour(String name) {
        apiService.deleteFlavour(name);
    }
}
