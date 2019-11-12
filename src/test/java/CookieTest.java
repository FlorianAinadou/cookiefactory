import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.cookie.Cookie;

public class CookieTest {
    private Cookie cookie;

    @BeforeEach
    public void setUp() {
        biblio = new Bibliotheque();
        livre = new Livre(biblio);
    }

    @Test
    public void EtudiantCreated() {

        assertEquals(false, livre.getEmprunte());
    }
}
