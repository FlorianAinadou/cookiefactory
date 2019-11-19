import model.cookie.parameters.CookieName;
import cookiefactory.CookieFactory;
import model.cookie.Cookie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lydia BARAUKOVA
 */
class CookieTest {

    private CookieFactory factory = new CookieFactory();
    private Cookie cookie;

    @BeforeEach
    void setUp() {
        cookie = factory.createCookie(CookieName.chocolala);
    }

   // @Test
    //void CookieCreated() {
      //  assertEquals(cookie.getUnitPriceEuro(), new Chocolala().getUnitPriceEuro());
   // }
}
