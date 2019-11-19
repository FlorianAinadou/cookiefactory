package cookie.ingredients;

/**
 * @author Lydia BARAUKOVA
 */
public enum Flavour {
    vanilla("Vanilla", 0.03), cinnamon("Cinnamon", 0.05), chili("Chili", 0.15), chocolate("Chocolate", 0.08),
    cherry("Cherry", 0.10);

    private final String type;
    private double price;

    Flavour(String t, double p) { type = t; price = p; }

    public double getPrice() { return price; }
    public void setPrice(double p) { price = p; }

    @Override
    public String toString() {
        return type;
    }
}
