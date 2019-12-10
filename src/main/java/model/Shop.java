package model;

import java.util.*;

/**
 * @author Aldric DUCREUX
 * @author Lydia BARAUKOVA
 */
public class Shop {
    private final int id;  // just a  random number given to every shop
    private String name, address;
    private Place city;
    private Date openingAt, closingAt;
    private double tax;
    private List<Order> orderHistory;
    private Recipe recipeOfTheMonth;

    public Shop(int id, String name, String address, Place city, Date openingAt, Date closingAt, double tax, Recipe recipeOfTheMonth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.openingAt = openingAt;
        this.closingAt = closingAt;
        this.tax = tax;
        this.orderHistory = new ArrayList<>();
        this.recipeOfTheMonth = recipeOfTheMonth;
    }

    public int getId() { return id; }
    public String getName() { return name;}
    public String getAddress() { return address; }
    public Place getCity() { return city; }
    public Date getOpeningHour() { return openingAt; }
    public Date getClosingHour() { return closingAt; }
    public  double getTax() { return tax; }

    public void setOpenHours(Date openingAt, Date closingAt) { this.openingAt = openingAt; this.closingAt = closingAt; }

    @Override
    public boolean equals( Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Order)) return false;
        return (((Order) obj).getId() == (this.getId()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }
}
