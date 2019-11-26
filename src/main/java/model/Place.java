package model;

public enum Place {
    Valbonne( "Valbonne"),
    Antibes ( "Antibes"),
    Biot ( "Biot"),
    Cannes ( "Cannes"),
    Nice( "Nice");

    private final String type;

    Place(String t) { type = t; }

    String getType() { return type; }
}
