package model.cookie.parameters;

/**
 * @author Lydia Baraukova
 */
public enum Mix {
    mixed("mixed"), topped("topped");

    private final String type;

    Mix(String t) { type = t; }

    @Override
    public String toString() {
        return type;
    }
}
