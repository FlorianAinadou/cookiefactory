package main.java.cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum Dough {
    plain("Plain"), chocolate("Chocolate"), peanutButter("Peanut butter"), oatmeal("Oatmeal");

    private final String type;

    Dough(String t) { type = t; }

    String getType() { return type; }
}
