package repository;

import api.ApiService;
import model.Recipe;
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
}
