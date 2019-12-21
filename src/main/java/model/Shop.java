package model;

import model.customer.Manager;

import java.util.*;

/**
 * @author Aldric DUCREUX
 * @author Lydia BARAUKOVA
 * @author Florian AINADOU
 */
public class Shop {
    private final int id;  // just a  random number given to every shop
    private String name, address;
    private Place city;
    private int openingAt, closingAt;
    private double tax, codTax;
    private List<Order> waitOrder;
    private List<Order> orderHistory;
    private Recipe recipeOfTheMonth;

    public Shop(int id, String name, String address, Place city, int openingAt, int closingAt, double tax, double codTax, Recipe recipeOfTheMonth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.openingAt = openingAt;
        this.closingAt = closingAt;
        this.tax = tax;
        this.codTax = codTax;
        this.waitOrder = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
        this.recipeOfTheMonth = recipeOfTheMonth;
    }


    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) {
        this.address = address;
    }

    public Place getCity() { return city; }
    public void setCity(Place city) {
        this.city = city;
    }

    public int getOpeningHour() { return openingAt; }
    public int getClosingHour() { return closingAt; }
    public void setOpeningHour(int newOpeningAt) {
        this.openingAt = newOpeningAt;
    }
    public void setClosingHour(int newClosingAt) {
        this.closingAt = newClosingAt;
    }
    public void setWorkingHours(int openingAt, int closingAt) { this.openingAt = openingAt; this.closingAt = closingAt; }

    public  double getTax() { return tax; }
    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getCodTax() {
        return codTax;
    }
    public void setCodTax(double codTax) {
        this.codTax = codTax;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    public void setOrderHistory(List<Order> orderHistory) { this.orderHistory = orderHistory; }
    public void emptyOrderHistory() { orderHistory.clear(); }

    public Recipe getRecipeOfTheMonth() { return recipeOfTheMonth; }
    public void setRecipeOfTheMonth(Recipe r) { this.recipeOfTheMonth = r; }


    public void shopPickUp(Order order) {
        waitOrder.remove(order);
        orderHistory.add(order);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Order)) return false;
        return (((Order) obj).getId() == (this.getId()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    public boolean inTheLastHour(int currentHour){
        if(currentHour< closingAt && currentHour>closingAt-1){
            return true;
        }
        return false;
    }
}
