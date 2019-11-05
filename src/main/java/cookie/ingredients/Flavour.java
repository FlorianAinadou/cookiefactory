package main.java.cookie.ingredients;

/**
 * @author Lydia BARAUKOVA
 */
public enum Flavour {
    vanilla("Vanilla"), cinnamon("Cinnamon"), chili("Chili");

    private final String type;

    Flavour(String t) {
        type = t;
    }

    String getType() { return type; }
}
