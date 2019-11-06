package cookiefactory;

import cookie.Cookie;
import cookie.parameters.CookieName;
import cookie.recipes.*;

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
