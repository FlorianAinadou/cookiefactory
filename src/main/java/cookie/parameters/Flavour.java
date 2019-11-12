package cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum Flavour {
    vanilla("Vanilla"), cinnamon("Cinnamon"), chili("Chili"), chocolate("Chocolate"), cherry("Cherry");

    private final String type;

    Flavour(String t) {
        type = t;
    }

    @Override
    public String toString() {
        return type;
    }
}
