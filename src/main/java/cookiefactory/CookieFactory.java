package cookiefactory;

import model.cookie.Cookie;
import model.cookie.parameters.CookieName;
/**
 * @author Lydia BARAUKOVA
 */
public class CookieFactory {

    public CookieFactory() {}

    public Cookie createCookie(CookieName n) {
        switch (n) {
            //case chocolala: return new Chocolala();
            //case cherryBlossom: return new CherryBlossom();
            //case darkTemptation: return new DarkTemptation();
            default: return null;
        }
    }
}
