package model.consumables.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum Cooking {
    crunchy("crunchy"), chewy("chewy");

    private final String type;

    Cooking(String t) { type = t; }

    @Override
    public String toString() {
        return type;
    }
}
