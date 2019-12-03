package model.consumables.ingredients;

/**
 * @author Lydia BARAUKOVA
 */
public enum Dough {
    plain("Plain", 0.05), chocolate("Chocolate", 0.12),
    peanutButter("Peanut butter", 0.10),
    oatmeal("Oatmeal", 0.08), cherryJam("Cherry jam", 0.15);

    private final String type;
    private double price;

    Dough(String t, double p) { type = t; price = p; }

    public double getPrice() { return price; }
    public void setPrice(double p) { price = p; }

    @Override
    public String toString() {
        return type;
    }
}
