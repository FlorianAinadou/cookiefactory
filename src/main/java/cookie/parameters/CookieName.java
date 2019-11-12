package cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum CookieName {
    chocolala("Chocolala"), darkTemptation("Dark temptation"), cherryBlossom("Cherry blossom");

    private final String type;

    CookieName(String t) { type = t; }

    @Override
    public String toString() {
        return type;
    }
}
