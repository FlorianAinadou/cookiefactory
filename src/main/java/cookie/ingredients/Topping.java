package cookie.ingredients;

/**
 * @author Lydia BARAUKOVA
 */
public enum Topping {
    whiteChocolate("White chocolate", 0.10), milkChocolate("Milk chocolate", 0.08), darkChocolate("Dark chocolate", 0.12),
    mNm("M&M's", 0.15), cherrySyrup("Cherry syrup", 0.18);

    private final String type;
    private double price;

    Topping(String t, double p) { type = t; price = p; }

    public double getPrice() { return price; }
    public void setPrice(double p) { price = p; }

    @Override
    public String toString() {
        return type;
    }
}
