package repository;


import api.ApiService;
import model.cookie.Cookie;
import model.cookie.Recipe;

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
}
