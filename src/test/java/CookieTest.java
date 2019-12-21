import di.Injection;
import model.Recipe;
import model.consumables.Cookie;
import model.consumables.CookieComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Lib;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lydia BARAUKOVA
 */
class CookieTest {

    private Cookie cookie;

    @BeforeEach
    void setUp() {
        cookie = new Cookie(new Recipe(Lib.CookieName.CHOCOLALA,2.00,new ArrayList<>(Arrays.asList(
                new CookieComponent(Lib.ComponentType.DOUGH, Lib.Dough.CHOCOLATE),
                new CookieComponent(Lib.ComponentType.COOKING, Lib.Cooking.CRUNCHY),
                new CookieComponent(Lib.ComponentType.FLAVOUR, Lib.Flavour.CHOCOLATE),
                new CookieComponent(Lib.ComponentType.MIX, Lib.Mix.TOPPED),
                new CookieComponent(Lib.ComponentType.TOPPING, Lib.Topping.MILK_CHOCOLATE)))));
    }

   @Test
   void CookieCreated() {
     // assertEquals(cookie, new Cookie(Injection.createCookieRepository().getRecipes().get(Lib.CookieName.CHOCOLALA)));
   }
}
