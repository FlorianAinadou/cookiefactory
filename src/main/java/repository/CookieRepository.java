package repository;


import api.ApiService;
import model.RecipeCookie;
import model.consumables.CookieComposant;

import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 */

public class CookieRepository {

    private final ApiService apiService;

    public CookieRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Map<String, RecipeCookie> getCookieRecipes() {
        return apiService.getCookieRecipes();
    }

    Map<String, CookieComposant> getCookieDough(){
        return apiService.getCookieDough();
    }

    Map<String, CookieComposant> getCookieTopping(){
        return apiService.getCookieTopping();
    }

    Map<String, CookieComposant> getCookieMix(){
        return apiService.getCookieMix();
    }

    Map<String, CookieComposant> getCookieCooking(){
        return apiService.getCookieCooking();
    }

    Map<String, CookieComposant> getCookieFlavour(){
        return apiService.getCookieFlavour();
    }
}
