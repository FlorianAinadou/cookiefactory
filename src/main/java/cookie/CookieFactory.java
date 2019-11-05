package main.java.cookie;

import main.java.utils.Recipe;
import main.java.cookie.cookielist.Chocolala;

/**
 * @author Lydia BARAUKOVA
 */
public class CookieFactory {
    private static CookieFactory instance = new CookieFactory();

    private CookieFactory() {}

    public static CookieFactory getInstance() {
        return instance;
    }

    public Cookie getCookie(String name) {
        switch (name) {
            case Recipe.CHOCOLALA: return new Chocolala();
            default: return null;
        }
    }
}
