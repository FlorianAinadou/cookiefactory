package main.java.cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum Flavour {
    vanilla("Vanilla"), cinnamon("Cinnamon"), chili("Chili"), chocolate("Chocolate");

    private final String type;

    Flavour(String t) {
        type = t;
    }

    String getType() { return type; }
}
