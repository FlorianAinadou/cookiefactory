package order;

public enum ReservationsPlace {
    Valbonne( "Valbonne"),
    Antibes ( "Antibes"),
    Nice( "Nice");

    private final String type;

    ReservationsPlace(String t) { type = t; }

    String getType() { return type; }
}
