package model.consumables;

import java.util.Objects;

public class CookieComponent {

    private int type;
    private String name;
    private double price;

    public CookieComponent(int type, String name) {
        this.type = type;
        this.name = name;
        this.price = 0f;
    }

    public CookieComponent(int type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals( Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof CookieComponent)) return false;
        return (((CookieComponent) obj).name.equals(this.name) && ((CookieComponent) obj).price == (this.price));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
