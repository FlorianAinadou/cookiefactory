package order;

public enum Place {
    Valbonne( "Valbonne"),
    Antibes ( "Antibes"),
    Nice( "Nice");

    private final String type;

    Place(String t) { type = t; }

    String getType() { return type; }
}
