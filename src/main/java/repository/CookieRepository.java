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

    public Map<String, Recipe> getCookieRecipes() {
        return apiService.getCookieRecipes();
    }
    public void addCookieRecipe(String name, Recipe recipe) { apiService.addCookieRecipe(name, recipe); }
    Map<String, CookieComponent> getCookieDough(){
        return apiService.getCookieDough();
    }
    Map<String, CookieComponent> getCookieTopping(){
        return apiService.getCookieTopping();
    }
    Map<String, CookieComponent> getCookieMix(){
        return apiService.getCookieMix();
    }
    Map<String, CookieComponent> getCookieCooking(){
        return apiService.getCookieCooking();
    }
    Map<String, CookieComponent> getCookieFlavour(){
        return apiService.getCookieFlavour();
    }
}
