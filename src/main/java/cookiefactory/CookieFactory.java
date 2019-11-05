package main.java.cookiefactory;

import main.java.cookie.Cookie;
import main.java.cookie.CookieName;
import main.java.cookie.recipes.Chocolala;

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
            default: return null;
        }
    }
}
