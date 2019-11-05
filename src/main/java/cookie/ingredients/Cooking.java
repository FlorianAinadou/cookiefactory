package main.java.cookie.ingredients;

/**
 * @author Lydia BARAUKOVA
 */
public enum Cooking {
    crunchy("crunchy"), chewy("chewy");

    private final String type;

    Cooking(String t) { type = t; }

    String getType() { return type; }
}
