package cookie.parameters;

/**
 * @author Lydia BARAUKOVA
 */
public enum Dough {
    plain("Plain"), chocolate("Chocolate"), peanutButter("Peanut butter"), oatmeal("Oatmeal"), cherryJam("Cherry jam");

    private final String type;

    Dough(String t) { type = t; }

    @Override
    public String toString() {
        return type;
    }
}
