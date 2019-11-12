package cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum Topping {
    whiteChocolate("White chocolate"), milkChocolate("Milk chocolate"), darkChocolate("Dark chocolate"),
    mNm("M&M's"), cherrySyrup("Cherry syrup");

    private final String type;

    Topping(String t) { type = t; }

    String getType() { return type; }
}
