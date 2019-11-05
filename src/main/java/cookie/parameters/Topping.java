package main.java.cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum Topping {
    whiteChocolate("White chocolate"), milkChocolate("Milk chocolate"), mNm("M&M's"), cherryJam("Cherry jam");

    private final String type;

    Topping(String t) { type = t; }

    String getType() { return type; }
}
