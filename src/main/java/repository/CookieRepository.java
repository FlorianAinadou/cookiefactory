package repository;

import api.ApiService;
import model.Recipe;
import model.consumables.CookieComponent;

import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 */
public class CookieRepository {

    private final ApiService apiService;

    public CookieRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Map<String, Recipe> getRecipes() {
        return apiService.getRecipes();
    }
    public void addRecipe(String name, Recipe recipe) { apiService.addRecipe(name, recipe); }
    public void deleteRecipe(String name) { apiService.deleteRecipe(name); }
    public void changeRecipeMargin(String name, double value) { apiService.changeRecipeMargin(name, value); }

    public Map<String, CookieComponent> getDough(){
        return apiService.getDough();
    }
    public void addDough(String name, CookieComponent dough) { apiService.addDough(name, dough); }
    public void deleteDough(String name) { apiService.deleteDough(name); }
    public void changeDoughPrice(String name, double price) { apiService.changeDoughPrice(name, price); }

    public Map<String, CookieComponent> getTopping(){
        return apiService.getTopping();
    }
    public void addTopping(String name, CookieComponent topping) { apiService.addTopping(name, topping); }
    public void deleteTopping(String name) { apiService.deleteTopping(name); }
    public void changeToppingPrice(String name, double price) { apiService.changeToppingPrice(name, price); }

    public Map<String, CookieComponent> getMix(){
        return apiService.getMix();
    }
    public void addMix(String name, CookieComponent mix) { apiService.addMix(name, mix); }
    public void deleteMix(String name) { apiService.deleteMix(name); }
    public void changeMixPrice(String name, double price) { apiService.changeMixPrice(name, price); }

    public Map<String, CookieComponent> getCooking(){
        return apiService.getCooking();
    }
    public void addCooking(String name, CookieComponent cooking) { apiService.addCooking(name, cooking); }
    public void deleteCooking(String name) { apiService.deleteCooking(name); }
    public void changeCookingPrice(String name, double price) { apiService.changeCookingPrice(name, price); }

    public Map<String, CookieComponent> getFlavour() { return apiService.getFlavour(); }
    public void addFlavour(String name, CookieComponent flavour) { apiService.addFlavour(name, flavour); }
    public void deleteFlavour(String name) { apiService.deleteFlavour(name); }
    public void changeFlavourPrice(String name, double price) { apiService.changeFlavourPrice(name, price); }
}
