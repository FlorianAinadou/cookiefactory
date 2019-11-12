package cookiefactory;

import cookie.Cookie;
import cookie.parameters.CookieName;
import cookie.recipes.*;

/**
 * @author Lydia BARAUKOVA
 */
public class CookieFactory {

    public CookieFactory() {}

    public Cookie createCookie(CookieName n) {
        switch (n) {
            case chocolala: return new Chocolala();
            case cherryBlossom: return new CherryBlossom();
            case darkTemptation: return new DarkTemptation();
            default: return null;
        }
    }
}
