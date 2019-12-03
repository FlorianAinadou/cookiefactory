import model.consumables.parameters.CookieName;
import cookiefactory.CookieFactory;
import model.consumables.Cookie;

import org.junit.jupiter.api.BeforeEach;

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
      //  assertEquals(consumables.getUnitPriceEuro(), new Chocolala().getUnitPriceEuro());
   // }
}
