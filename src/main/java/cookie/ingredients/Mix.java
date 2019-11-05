package main.java.cookie.ingredients;

/**
 * @author Lydia Baraukova
 */
public enum Mix {
    mixed("mixed"), topped("topped");

    private final String type;

    Mix(String t) { type = t; }

    String getType() { return type; }
}
