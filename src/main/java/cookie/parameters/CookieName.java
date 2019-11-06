package cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum CookieName {
    chocolala("Chocolala"), darkTemptation("Dark temptation"), cherryBlossom("Cherry blossom");

    private final String type;

    CookieName(String t) { type = t; }

    public String getType() { return type; }
}
