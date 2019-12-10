package model;

/**
 * @author Lydia BARAUKOVA
 */
public enum Place {
    Biot ( "Biot"),
    Cannes ( "Cannes"),
    Nice( "Nice");

    private final String type;

    Place(String t) { type = t; }

    @Override
    public String toString() { return type; }
}
