package model.consumables;

public class PackComposition {
    private final int cookiesNumber;
    private final double packPrice;

    public PackComposition(int cookiesNumber, double packPrice) {
        this.cookiesNumber = cookiesNumber;
        this.packPrice = packPrice;
    }

    public double getPackPrice() {
        return packPrice;
    }

    public int getCookiesNumber() {
        return cookiesNumber;
    }
}
