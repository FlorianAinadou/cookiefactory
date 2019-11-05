package main.java.cookiefactory;

import main.java.cookie.Cookie;
import main.java.cookie.parameters.CookieName;
import main.java.cookie.recipes.CherryBlossom;
import main.java.cookie.recipes.Chocolala;
import main.java.cookie.recipes.DarkTemptation;

/**
 * @author Lydia BARAUKOVA
 */
public class CookieFactory {
    private static CookieFactory instance = new CookieFactory();

    private CookieFactory() {}

    public static CookieFactory getInstance() {
        return instance;
    }

    public Cookie getCookie(CookieName n) {
        switch (n) {
            case chocolala: return new Chocolala();
            case cherryBlossom: return new CherryBlossom();
            case darkTemptation: return new DarkTemptation();
            default: return null;
        }
    }
}
