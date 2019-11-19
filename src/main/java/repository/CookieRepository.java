package repository;


import api.ApiService;
import cookie.Cookie;
import order.Order;

import java.util.List;
import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 */

public class CookieRepository {

    private final ApiService apiService;

    public CookieRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Map<String, Cookie> getCookieRecipes() {
        return apiService.getCookieRecipes();
    }
}
